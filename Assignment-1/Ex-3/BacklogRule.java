import java.util.Optional;

public class BacklogRule implements EligibilityRule {

    public Optional<String> validate(StudentProfile s) {
        // example if you later add backlog field
        return Optional.empty();
    }
}