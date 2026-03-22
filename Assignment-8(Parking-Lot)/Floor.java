import java.util.ArrayList;
import java.util.HashMap;

public class Floor {
  ArrayList<EntryGate> entryGate = new ArrayList<>();
  HashMap<SpotType, Integer> availableCount = new HashMap<>();

  public void assignSpot(ParkingSpot spot) {

    spot.isOccupied = true;

    availableCount.put(
        spot.type,
        availableCount.get(spot.type) - 1);

    for (EntryGate g : entryGate) {
      g.availableSpots.removeIf(sd -> sd.spot == spot);
    }
  }

  public void freeSpot(ParkingSpot spot) {

    spot.isOccupied = false;

    availableCount.put(
        spot.type,
        availableCount.get(spot.type) + 1);

    for (EntryGate g : entryGate) {
      g.availableSpots.add(
          new SpotDistance(spot, computeDistance(g, spot)));
    }
  }

  private int computeDistance(EntryGate g, ParkingSpot s) {
    return Math.abs(g.hashCode() - s.hashCode());
  }
}
