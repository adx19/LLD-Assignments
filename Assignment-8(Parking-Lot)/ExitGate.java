import java.time.LocalDateTime;

public class ExitGate {

  Floor floor;
  BillingService billingService;

  public ExitGate(Floor floor, BillingService billingService) {
    this.floor = floor;
    this.billingService = billingService;
  }

  public double getBill(ParkingTicket ticket, LocalDateTime outTime) {

    double amount = billingService.generateBill(ticket, outTime);

    floor.freeSpot(ticket.spot);

    return amount;
  }
}