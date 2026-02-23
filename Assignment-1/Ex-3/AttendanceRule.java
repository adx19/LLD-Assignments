import java.util.Optional;

public class AttendanceRule implements EligibilityRule {

    private final RuleInput config;

    public AttendanceRule(RuleInput config) {
        this.config = config;
    }

    public Optional<String> validate(StudentProfile s) {
        if (s.attendancePct < config.minAttendance) {
            return Optional.of("attendance below " + config.minAttendance);
        }
        return Optional.empty();
    }
}