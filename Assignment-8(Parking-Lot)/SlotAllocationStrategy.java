public interface SlotAllocationStrategy {
  ParkingSpot findSpot(EntryGate gate, SpotType type);
}
