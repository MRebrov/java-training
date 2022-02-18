package Advantum;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class FourthTask {

    private final static Map<Integer, Instant> trucksToTime = new HashMap<>();

    public void receiveCoordinates(int truckId, int x, int y, Instant measurementTime){
        if (trucksToTime.containsKey(truckId)) {
            if (measurementTime.isBefore(trucksToTime.get(truckId)) || measurementTime.equals(trucksToTime.get(truckId))) {
                return;
            }
        }
        trucksToTime.put(truckId, measurementTime);
        processCoordinates(truckId, x, y, measurementTime);
    }

    public void processCoordinates(int truckId, int x, int y, Instant measurementTime){
        System.out.println("Пришел пакет "+truckId+" "+x+" "+y+" "+ measurementTime);
    }

    public static void main(String[] args) {
        FourthTask ft = new FourthTask();
        trucksToTime.put(1, Instant.now());
        trucksToTime.put(2, Instant.EPOCH);
        ft.receiveCoordinates(1, 1, 1, Instant.now().minusSeconds(1L));
        ft.receiveCoordinates(1, 1, 1, Instant.now().plusSeconds(1L));
        ft.receiveCoordinates(1, 1, 1, Instant.now().plusSeconds(2L));
        ft.receiveCoordinates(2, 2, 2, Instant.EPOCH.plusSeconds(1L));
        ft.receiveCoordinates(2, 2, 2, Instant.EPOCH.plusSeconds(1L));
    }
}
