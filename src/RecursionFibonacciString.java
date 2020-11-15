public class RecursionFibonacciString {

    public static void main(String[] args) {

        System.out.println(generate(5, new String[] {"e", "a"}));

    }

    public static String generate(int n, String[] s) {
        if (n <= 1) {
            return "invalid";
        }
        if (n == 2) {
            return s[0] + ", " + s[1];
        }

        String[] str = new String[n];
        str[0] = s[0];
        str[1] = s[1];

        System.out.println(str[0]+ " "+ str[1]);

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
            System.out.println(s[count]);
            count++;
            return theResult(s, count);
        }
    }
}
