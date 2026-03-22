public class ParkingSpot {
  int spotNumber;
  SpotType type;
  boolean isOccupied;

  public ParkingSpot(int no, SpotType type){
    this.spotNumber = no;
    this.type = type;
    this.isOccupied = false;
  }

}
