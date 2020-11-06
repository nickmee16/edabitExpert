public class ExactFactorialBounds {

    public static void main(String[] args) {

    }

    public static long[] isExact(long n) {
        int fact = 0;
        long temp = 1;

        for(int i = 1; i < n; i++) {
            temp *= i;

            if(temp == n) {
                fact = i;
                break;
            } else if(temp > n) {
                break;
            }
        }

        if(fact == 0) {
            return new long[] {};
        }

        return new long[]{n, fact};

    }
}
