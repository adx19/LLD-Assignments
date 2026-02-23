import java.util.List;

public class OnboardingService {

    private final StudentRepository repo;
    private final StudentInputParser parser;
    private final StudentValidator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(StudentRepository repo,
                             StudentInputParser parser,
                             StudentValidator validator,
                             OnboardingPrinter printer) {
        this.repo = repo;
        this.parser = parser;
        this.validator = validator;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {

        printer.printInput(raw);

        StudentData data = parser.parse(raw);

        List<String> errors = validator.validate(data);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());

        StudentRecord rec = new StudentRecord(
                id, data.name, data.email, data.phone, data.program
        );

        repo.save(rec);

        printer.printSuccess(rec, repo.count());
    }
}