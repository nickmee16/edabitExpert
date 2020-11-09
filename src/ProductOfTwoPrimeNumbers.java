import java.util.ArrayList;

public class ProductOfTwoPrimeNumbers {

    public static void main(String[] args) {

        System.out.println(productOfPrimes(2059));
        System.out.println(productOfPrimes(10));
        System.out.println(productOfPrimes(25));
        System.out.println(productOfPrimes(999));

    }

    public static boolean productOfPrimes(int num) {
        ArrayList<Integer> primeNums = new ArrayList<>();

        boolean isPrime;

        for (int i = 2; i <= num; i++) {
            isPrime = true;
            for (int y = 2; y <= i / 2; y++) {
                if (i % y == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNums.add(i);
            }
        }

        boolean isCorrect = false;

        for(int i = 0; i < primeNums.size(); i++) {
            if(num % primeNums.get(i) == 0 && primeNums.contains(num / primeNums.get(i))) {
                isCorrect = true;
                break;
            }
        }

        return isCorrect;
    }
}
