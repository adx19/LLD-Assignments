import java.time.LocalDateTime;

public class ParkingTicket {

    Vehicle vehicle;
    ParkingSpot spot;
    EntryGate entryGate;
    LocalDateTime inTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot, EntryGate entryGate, LocalDateTime inTime){
      this.vehicle = vehicle;
      this.spot = spot;
      this.entryGate = entryGate;
      this.inTime = inTime;
    }

}
