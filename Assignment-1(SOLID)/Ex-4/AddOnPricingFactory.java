import java.util.*;

public class AddOnPricingFactory {

    private static final Map<AddOn, AddOnPricing> PRICING = Map.of(
            AddOn.MESS, new FixedAddOnPricing(1000),
            AddOn.LAUNDRY, new FixedAddOnPricing(500),
            AddOn.GYM, new FixedAddOnPricing(300),
            AddOn.WIFI, new FixedAddOnPricing(400)
    );

    public static AddOnPricing of(AddOn addOn) {
        return PRICING.get(addOn);
    }
}