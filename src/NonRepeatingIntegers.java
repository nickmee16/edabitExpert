public class NonRepeatingIntegers {

    public static void main(String[] args) {

        System.out.println(nonRepeats(2));
        System.out.println(nonRepeats(3));
        System.out.println(nonRepeats(5));
        System.out.println(nonRepeats(6));

    }

    public static int nonRepeats(int radix) {
        int total = 0;

        for (int i = 1; i <= radix; i++) {
            int product = radix-1;

            for (int j = 1; j < i; j++) {
                product *= radix-j;
            }

            total += product;

        }
        return total;
    }
}
