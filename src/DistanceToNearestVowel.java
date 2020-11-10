import java.util.Arrays;

public class DistanceToNearestVowel {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(distanceToNearestVowel("aaaaa")));
        System.out.println(Arrays.toString(distanceToNearestVowel("babbb")));
        System.out.println(Arrays.toString(distanceToNearestVowel("abcdabcd")));
        System.out.println(Arrays.toString(distanceToNearestVowel("shopper")));

    }

    public static int[] distanceToNearestVowel(String str) {
        int[] distances = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            distances[i] = checkDistances(str, i);
        }

        return distances;
    }

    public static int checkDistances(String str, int i) {

        int countUp = 0;
        int countDown = 0;
        boolean downIsNotZero = true;
        boolean upIsNotEnd = true;
        int num = 0;

        if (str.charAt(i) == 'a'
                || str.charAt(i) == 'e'
                || str.charAt(i) == 'u'
                || str.charAt(i) == 'i'
                || str.charAt(i) == 'o') {
            return 0;
        }


        for (int j = i; j >= 0; j--) {
            boolean isNotVowel = (str.charAt(j) != 'a'
                    && str.charAt(j) != 'e'
                    && str.charAt(j) != 'u'
                    && str.charAt(j) != 'i'
                    && str.charAt(j) != 'o');

            if (j == 0 && isNotVowel) {
                downIsNotZero = false;
                break;
            }
            if (isNotVowel) {
                countDown++;
            } else {
                break;
            }
        }

        for (int j = i; j < str.length(); j++) {
            boolean isNotVowel = (str.charAt(j) != 'a'
                    && str.charAt(j) != 'e'
                    && str.charAt(j) != 'u'
                    && str.charAt(j) != 'i'
                    && str.charAt(j) != 'o');

            if (j == str.length() - 1 && isNotVowel) {
                upIsNotEnd = false;
                break;
            }

            if (isNotVowel) {
                countUp++;
            } else {
                break;
            }
        }
        if (downIsNotZero && upIsNotEnd) {
            num = Math.min(countUp, countDown);

        } else if (downIsNotZero) {
            num = countDown;

        } else if (upIsNotEnd) {
            num = countUp;
        }

        return num;
    }
}
