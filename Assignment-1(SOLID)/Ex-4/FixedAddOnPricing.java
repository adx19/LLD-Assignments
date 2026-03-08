public class FixedAddOnPricing implements AddOnPricing {

    private final Money price;

    public FixedAddOnPricing(double price) {
        this.price = new Money(price);
    }

    public Money monthly() {
        return price;
    }
}