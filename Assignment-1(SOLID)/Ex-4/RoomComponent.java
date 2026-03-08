public class RoomComponent implements FeeComponent {

    private final RoomPricing pricing;

    public RoomComponent(RoomPricing pricing) {
        this.pricing = pricing;
    }

    public Money monthly() {
        return pricing.monthly();
    }
}