package Factorial;

public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.getFactorial(8));
    }

    int getFactorial(int num) {
        if (num < 2) {
            return 1;
        } else {
            return num * getFactorial(num - 1);
        }
    }
}
