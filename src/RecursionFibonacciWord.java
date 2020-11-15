public class RecursionFibonacciWord {

    public static void main(String[] args) {

    }

    public static String generateWord(int n) {
        if (n < 2) {
            return "invalid";
        }
        if (n == 2) {
            return  "b, a";
        }

        String[] str = new String[n];
        str[0] = "b";
        str[1] = "a";

        return theResult(str, 2);
    }

    public static String theResult(String[] s, int count) {
        if (count == s.length) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                if(i == s.length - 1) {
                    str.append(s[i]);
                } else {
                    str.append(s[i]).append(", ");
                }
            }

            return str.toString().trim();
        } else {
            s[count] = s[count - 1] + s[count - 2];
            count++;
            return theResult(s, count);
        }
    }
}
