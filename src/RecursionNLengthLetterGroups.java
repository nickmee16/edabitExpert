import java.util.Arrays;

public class RecursionNLengthLetterGroups {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));

    }

    public static String[] collect(String s, int n) {
        if(s.length() < n) {
            return new String[]{};
        }

        String[] strArr = theResult(s, new String[s.length() / n], n, 0, 0);
        Arrays.sort(strArr);
        return strArr;
    }

    public static String[] theResult(String str, String[] arr, int n, int count, int position) {
        arr[count] = str.substring(position, position + n);

        if(count == arr.length - 1) {
            return arr;

        } else {
            position = position + n;
            count++;
            return theResult(str, arr, n, count, position);
        }
    }
}
