package com.example.demo.service.impl;

import com.example.demo.entity.FinancialProfile;
import com.example.demo.entity.LoanRequest;
import com.example.demo.entity.RiskAssessmentLog;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FinancialProfileRepository;
import com.example.demo.repository.LoanRequestRepository;
import com.example.demo.repository.RiskAssessmentLogRepository;
import com.example.demo.service.RiskAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentServiceImpl implements RiskAssessmentService {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final RiskAssessmentLogRepository logRepo;

    public RiskAssessmentServiceImpl(LoanRequestRepository loanRepo,
                                     FinancialProfileRepository profileRepo,
                                     RiskAssessmentLogRepository logRepo) {
        this.loanRepo = loanRepo;
        this.profileRepo = profileRepo;
        this.logRepo = logRepo;
    }

    @Override
    public RiskAssessmentLog assessRisk(Long loanRequestId) {

        if (!logRepo.findByLoanRequestId(loanRequestId).isEmpty()) {
            throw new BadRequestException("Risk already assessed");
        }

        LoanRequest loan = loanRepo.findById(loanRequestId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan request not found"));

        FinancialProfile profile = profileRepo.findByUserId(loan.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Financial profile not found"));

        double dti = (profile.getMonthlyExpenses() + profile.getExistingLoanEmi())
                / profile.getMonthlyIncome();

        RiskAssessmentLog log = new RiskAssessmentLog();
        log.setLoanRequestId(loanRequestId);
        log.setDtiRatio(dti);
        log.setCreditCheckStatus(dti < 0.4 ? "APPROVED" : "PENDING_REVIEW");

        return logRepo.save(log);
    }

    @Override
    public RiskAssessmentLog getByLoanRequestId(Long loanRequestId) {
        return logRepo.findByLoanRequestId(loanRequestId)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Risk log not found"));
    }
}
