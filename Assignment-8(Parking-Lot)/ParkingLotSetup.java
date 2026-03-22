import java.util.*;

public class ParkingLotSetup {

    public static ParkingLot createParkingLot() {

        Map<SpotType, Double> rates = new HashMap<>();
        rates.put(SpotType.SMALL, 10.0);
        rates.put(SpotType.MEDIUM, 20.0);
        rates.put(SpotType.LARGE, 30.0);

        BillingService billingService = new BillingService(rates);

        ParkingLot lot = new ParkingLot();

        Floor floor1 = new Floor();
        lot.floors.add(floor1);

        SlotAllocationStrategy strategy = new NearestSlot();

        EntryGate gate1 = new EntryGate(1, floor1, strategy);
        EntryGate gate2 = new EntryGate(2, floor1, strategy);

        floor1.entryGate.add(gate1);
        floor1.entryGate.add(gate2);

        lot.gateMap.put(1, gate1);
        lot.gateMap.put(2, gate2);

        ExitGate exitGate = new ExitGate(floor1, billingService);
        lot.exitGate.add(exitGate);

        List<ParkingSpot> spots = new ArrayList<>();
        spots.add(new ParkingSpot(1, SpotType.SMALL));
        spots.add(new ParkingSpot(2, SpotType.SMALL));
        spots.add(new ParkingSpot(3, SpotType.MEDIUM));
        spots.add(new ParkingSpot(4, SpotType.LARGE));

        floor1.availableCount.put(SpotType.SMALL, 2);
        floor1.availableCount.put(SpotType.MEDIUM, 1);
        floor1.availableCount.put(SpotType.LARGE, 1);

        for (ParkingSpot spot : spots) {
            for (EntryGate gate : floor1.entryGate) {
                int distance = Math.abs(gate.hashCode() - spot.hashCode());
                gate.availableSpots.add(new SpotDistance(spot, distance));
            }
        }

        return lot;
    }
}