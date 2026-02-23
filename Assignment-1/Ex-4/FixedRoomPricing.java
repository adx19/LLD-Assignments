public class FixedRoomPricing implements RoomPricing {

    private final Money price;

    public FixedRoomPricing(double price) {
        this.price = new Money(price);
    }

    public Money monthly() {
        return price;
    }
}