import java.util.*;

public class HostelFeeCalculator {

    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
    }

    public void process(BookingRequest req) {

        boolean late = false; // change to true to test late fee

        List<FeeComponent> components = buildComponents(req, late);

        Money monthly = new Money(0);
        for (FeeComponent c : components) {
            monthly = monthly.plus(c.monthly());
        }

        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private List<FeeComponent> buildComponents(BookingRequest req, boolean late) {

        List<FeeComponent> list = new ArrayList<>();

        list.add(new RoomComponent(RoomPricingFactory.of(req.roomType)));

        for (AddOn a : req.addOns) {
            list.add(new AddOnComponent(AddOnPricingFactory.of(a)));
        }

        list.add(new LateFeeComponent(late));

        return list;
    }
}