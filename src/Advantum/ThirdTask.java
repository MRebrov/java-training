package Advantum;

import java.util.HashMap;
import java.util.Map;

public class ThirdTask {

    public static Map<Long, Long> trucksToDriver = Map.of(1L, 10L, 2L, 20L, 3L, 30L); // сопоставляет id грузовика с id водителя, назначенного на грузовик
    public static Map<Long, String> driversToTabelNumber = Map.of(10L, "first", 20L, "second", 30L, "third"); // сопоставляет id водителя с его табельным номером


    public static Map<String, Long> tableNumberToTruck = new HashMap<>();

    static {
        trucksToDriver.forEach((Long key, Long value) -> {
            tableNumberToTruck.put(driversToTabelNumber.get(value), key);
        });
    }

    public static void main(String[] args) {
        System.out.println(tableNumberToTruck);
    }

}
