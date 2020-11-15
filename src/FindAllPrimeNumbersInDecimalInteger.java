import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindAllPrimeNumbersInDecimalInteger {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(extractPrimes(1)));
        System.out.println(Arrays.toString(extractPrimes(7)));
        System.out.println(Arrays.toString(extractPrimes(73)));
        System.out.println(Arrays.toString(extractPrimes(1313)));
        System.out.println(Arrays.toString(extractPrimes(10234)));

    }

    public static int[] extractPrimes(int num) {
        if (num <= 1) {
            return new int[]{};
        }

        String strNum = Integer.toString(num);
        int temp;
        ArrayList<Integer> primeNums = new ArrayList<>();
        boolean isPrime;

        for (int i = 1; i <= strNum.length(); i++) {

            for (int j = 0; j < strNum.length(); j++) {
                if (j + i > strNum.length()) {
                    break;
                }
                if (!strNum.substring(j, j + i).equals("1") && strNum.substring(j, j + i).charAt(0) != '0') {
                    temp = Integer.parseInt(strNum.substring(j, j + i));

                    isPrime = true;
                    for (int y = 2; y <= temp / 2; y++) {

                        if (temp % y == 0) {
                            isPrime = false;
                            break;
                        }
                    }

                    if (isPrime) {
                        primeNums.add(temp);
                    }
                }

            }
        }

        Collections.sort(primeNums);
        int[] nums = new int[primeNums.size()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = primeNums.get(i);
        }

        return nums;
    }
}