package Advantum;

public class FirstTask {
    public String trucksAndCargo(int x1, int x2, int xCargo) {
        int dif1 = Math.abs(xCargo - x1);
        int dif2 = Math.abs(xCargo - x2);
        if (dif1 > dif2) {
            return "2";
        } else if (dif1 < dif2) {
            return "1";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        FirstTask f1 = new FirstTask();
        System.out.println(f1.trucksAndCargo(1, 2, 3));
        System.out.println(f1.trucksAndCargo(-1, -2, 3));
        System.out.println(f1.trucksAndCargo(-1, 1, 0));
        System.out.println(f1.trucksAndCargo(1, -2, -3));
    }
}
