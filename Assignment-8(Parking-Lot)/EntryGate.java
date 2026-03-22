import java.util.TreeSet;

class EntryGate {

    int gateId;
    Floor floor;
    SlotAllocationStrategy strategy;
    TreeSet<SpotDistance> availableSpots = new TreeSet<>();

    public EntryGate(int id, Floor floor, SlotAllocationStrategy strategy) {
        this.gateId = id;
        this.floor = floor;
        this.strategy = strategy;
    }
}