import java.util.Optional;

public class CGRRule implements EligibilityRule {

    private final RuleInput config;

    public CGRRule(RuleInput config) {
        this.config = config;
    }

    public Optional<String> validate(StudentProfile s) {
        if (s.cgr < config.minCgr) {
            return Optional.of("CGR below " + config.minCgr);
        }
        return Optional.empty();
    }
}