public class LateFeeComponent implements FeeComponent {

    private final boolean applicable;

    public LateFeeComponent(boolean applicable) {
        this.applicable = applicable;
    }

    public Money monthly() {
        return applicable ? new Money(200) : new Money(0);
    }
}