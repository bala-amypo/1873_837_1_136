@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repo;
    private final UserRepository userRepo;

    public LoanRequestServiceImpl(LoanRequestRepository repo,
                                  UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public LoanRequest submitRequest(LoanRequest request) {

        if (request.getRequestedAmount() <= 0) {
            throw new BadRequestException("Requested amount");
        }

        return repo.save(request);
    }

    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public LoanRequest getById(Long id) {
        return repo.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Loan request not found"));
    }
}
