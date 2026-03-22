import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {
    ParkingLot lot = ParkingLotSetup.createParkingLot();

    Vehicle v1 = new Vehicle("KA01AB1234", "Red", "Honda");
    Vehicle v2 = new Vehicle("KA01CD5678", "Black", "Hyundai");
    ParkingTicket ticket = ParkingTicketFactory.generateTicket(v1, SpotType.SMALL, 1, LocalDateTime.now(), lot);
    ParkingTicket ticket2 = ParkingTicketFactory.generateTicket(v2, SpotType.MEDIUM, 2, LocalDateTime.now(), lot);

    System.out.println("Parked at spot: " + ticket.spot.spotNumber);

    LocalDateTime outTime = ticket.inTime.plusMinutes(70);

    double bill = lot.exitGate.get(0).getBill(ticket, outTime);

    System.out.println("Bill amount: " + bill);

    System.out.println("Parked at spot: " + ticket2.spot.spotNumber);

    LocalDateTime outTime2 = ticket.inTime.plusMinutes(80);

    double bill2 = lot.exitGate.get(0).getBill(ticket, outTime2);

    System.out.println("Bill amount: " + bill2);
  }
}
