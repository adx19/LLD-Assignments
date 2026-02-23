public class AddOnComponent implements FeeComponent {

    private final AddOnPricing pricing;

    public AddOnComponent(AddOnPricing pricing) {
        this.pricing = pricing;
    }

    public Money monthly() {
        return pricing.monthly();
    }
}