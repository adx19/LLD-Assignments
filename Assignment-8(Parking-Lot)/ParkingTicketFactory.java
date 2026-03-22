import java.time.LocalDateTime;

public class ParkingTicketFactory {
  public static ParkingTicket generateTicket(
      Vehicle v,
      SpotType type,
      int gateId,
      LocalDateTime inTime,
      ParkingLot lot) {

    EntryGate gate = lot.getGate(gateId);

    if (gate == null) {
      throw new RuntimeException("Invalid gate");
    }

    ParkingSpot spot = gate.strategy.findSpot(gate, type);

    if (spot == null) {
      throw new RuntimeException("No spot available");
    }

    gate.floor.assignSpot(spot);

    return new ParkingTicket(v, spot, gate, inTime);

  }
}
