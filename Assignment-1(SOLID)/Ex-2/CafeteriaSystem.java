import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();

    private final PricingService pricingService;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoiceFormatter formatter;
    private final InvoiceRepository repository;
    private final InvoiceIdGenerator idGenerator;

    public CafeteriaSystem(
            PricingService pricingService,
            TaxPolicy taxPolicy,
            DiscountPolicy discountPolicy,
            InvoiceFormatter formatter,
            InvoiceRepository repository,
            InvoiceIdGenerator idGenerator
    ) {
        this.pricingService = pricingService;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
        this.formatter = formatter;
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = idGenerator.nextId();

        double subtotal = pricingService.subtotal(lines, menu);

        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountPolicy.discount(customerType, subtotal, lines);

        double total = subtotal + tax - discount;

        String printable = formatter.format(
                invId, lines, menu, subtotal, taxPct, tax, discount, total
        );

        System.out.print(printable);

        repository.save(invId, printable);

        System.out.println(
                "Saved invoice: " + invId +
                        " (lines=" + repository.countLines(invId) + ")"
        );
    }
}