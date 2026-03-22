public class SpotDistance implements Comparable<SpotDistance> {

  ParkingSpot spot;
  int distance;

  public SpotDistance(ParkingSpot s, int d) {
    this.spot = s;
    this.distance = d;
  }

  public ParkingSpot getSpot() {
    return spot;
  }

  public int compareTo(SpotDistance o) {
    if (this.distance != o.distance) {
      return this.distance - o.distance;
    }
    return this.spot.hashCode() - o.spot.hashCode();
  }
}