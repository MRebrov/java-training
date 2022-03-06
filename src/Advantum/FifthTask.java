package Advantum;

public class FifthTask {

    long x;
    long y;

    public boolean hasObject(long x1, long x2, long y1, long y2) {
        if (x1 <= 1111111111111111111L && x2 >= 1111111111111111111L && y1 <= -1111111111111111111L && y2 >= -1111111111111111111L) {
            return true;
        }
        return false;
    }

    public FifthTask findObject() {
        long x1 = Long.MIN_VALUE;
        long x2 = Long.MAX_VALUE;
        long y1 = Long.MIN_VALUE;
        long y2 = Long.MAX_VALUE;
        long mid;
        while (x1 <= x2) {
            mid = x1/2 + x2/2;
            if (hasObject(mid, x2, y1, y2)) {
                x1 = mid + 1;
            } else if (hasObject(x1, mid, y1, y2)) {
                x2 = mid - 1;
            } else {
                break;
            }
            x = mid;
        }
        while (y1 <= y2) {
            mid = y1/2 + y2/2;
            if (hasObject(x, x, mid, y2)) {
                y1 = mid + 1;
            } else if (hasObject(x, x, y1, mid)) {
                y2 = mid - 1;
            } else {
                break;
            }
            y = mid;
        }
        return this;
    }

    public static void main(String[] args) {
        FifthTask ft = new FifthTask();
        ft.findObject();
        System.out.println(ft.x);
        System.out.println(ft.y);
    }
}