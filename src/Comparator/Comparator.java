package Comparator;

import java.util.List;

public class Comparator {
    static List<Integer> numbers =
            List.of(-2, 9, 55, 43, 99, 98, -7, -11);

    public static int compareDifference() {
        int result = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                int num1 = numbers.get(i);
                int num2 = numbers.get(j);
                int intermediateResult = num1 - num2;
                intermediateResult = Math.abs(intermediateResult);
                if (j == 1) {
                    result = intermediateResult;
                }
                if (intermediateResult < result) {
                    result = intermediateResult;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("The result is: ");
        System.out.println(compareDifference());
    }
}
