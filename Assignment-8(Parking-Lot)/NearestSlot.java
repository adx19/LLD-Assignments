public class NearestSlot implements SlotAllocationStrategy{
  public ParkingSpot findSpot(EntryGate gate, SpotType type){
    for(SpotDistance sd : gate.availableSpots){
      ParkingSpot s = sd.getSpot();
      if(!s.isOccupied && s.type == type){
        return s;
      }
    }

    return null;
  }
}
