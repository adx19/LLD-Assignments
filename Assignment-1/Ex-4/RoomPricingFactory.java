import java.util.*;

public class RoomPricingFactory {

    private static final Map<Integer, RoomPricing> PRICING = Map.of(
            LegacyRoomTypes.SINGLE, new FixedRoomPricing(14000),
            LegacyRoomTypes.DOUBLE, new FixedRoomPricing(15000),
            LegacyRoomTypes.TRIPLE, new FixedRoomPricing(12000),
            LegacyRoomTypes.DELUXE, new FixedRoomPricing(16000),
            LegacyRoomTypes.SUITE, new FixedRoomPricing(20000)
    );

    public static RoomPricing of(int roomType) {
        return PRICING.get(roomType);
    }
}