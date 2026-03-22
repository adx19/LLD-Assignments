import java.util.ArrayList;
import java.util.HashMap;
public class ParkingLot {

    ArrayList<Floor> floors = new ArrayList<>();
    HashMap<Integer, EntryGate> gateMap = new HashMap<>();
    ArrayList<ExitGate> exitGate = new ArrayList<ExitGate>();
    public EntryGate getGate(int gateId) {
        return gateMap.get(gateId);
    }
}