import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class BillingService {

  Map<SpotType, Double> rate;

  public BillingService(Map<SpotType, Double> rate) {
    this.rate = rate;
  }

  public double generateBill(
      ParkingTicket ticket,
      LocalDateTime outTime) {

    long minutes = Duration.between(
        ticket.inTime, outTime).toMinutes();

    long hours = (minutes + 59) / 60; // ceiling division

    return hours * rate.get(ticket.spot.type);
  }
}