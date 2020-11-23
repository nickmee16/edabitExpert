import java.util.Arrays;

public class DeepArithmetic {

    public static void main(String[] args) {

    }

    public static int sum(Object... arrays) {
        String[] numbers = Arrays.deepToString(arrays).split("-(?!\\d+)|[^-\\d+]+");
        int sum = 0;

        for (int i = 1; i < numbers.length; i++) {
            sum += Integer.parseInt(numbers[i]);
        }

        return sum;
    }
}
