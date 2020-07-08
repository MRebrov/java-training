package FibonacciNumber;

public class FibonacciNumber {

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.getNumberById(8));
    }

    public int getNumberById(int id) {
        if (id == 0) {
            return 0;
        } else if (id > 1) {
            return getNumberById(id - 1) + getNumberById(id - 2);
        }
        return 1;
    }
}
