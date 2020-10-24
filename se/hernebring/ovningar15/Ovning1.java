package se.hernebring.ovningar15;
import java.util.ArrayList;
import java.util.List;

public class Ovning1 {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1); // index 0
        test.add(4);
        test.add(0);
        test.add(2);
        test.add(5);
        test.add(1);
        test.add(3);
        test.add(999); // index 7 => size = 8
        System.out.println(evenSum(test));
    }

    private static int evenSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                // only adds even numbers to sum
                sum += number;
            }
        }
        return sum;
    }
}
