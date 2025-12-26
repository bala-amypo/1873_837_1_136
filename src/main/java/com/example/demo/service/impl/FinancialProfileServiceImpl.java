@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository repo;
    private final UserRepository userRepo;

    public FinancialProfileServiceImpl(FinancialProfileRepository repo,
                                       UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public FinancialProfile createOrUpdate(FinancialProfile fp) {

        if (fp.getCreditScore() < 300 || fp.getCreditScore() > 900) {
            throw new BadRequestException("creditScore");
        }

        return repo.save(fp);
    }

    public FinancialProfile getByUserId(Long userId) {
        return repo.findByUserId(userId)
            .orElseThrow(() ->
                new ResourceNotFoundException("Financial profile not found"));
    }
}
