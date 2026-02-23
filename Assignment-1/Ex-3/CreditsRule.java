import java.util.Optional;

public class CreditsRule implements EligibilityRule {

    private final RuleInput config;

    public CreditsRule(RuleInput config) {
        this.config = config;
    }

    public Optional<String> validate(StudentProfile s) {
        if (s.earnedCredits < config.minCredits) {
            return Optional.of("credits below " + config.minCredits);
        }
        return Optional.empty();
    }
}