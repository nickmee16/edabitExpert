public class RepeatedString {

    public static void main(String[] args) {

        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
        System.out.println(repeatedString("aab",882787));

    }

    public static long repeatedString(String s, long n) {
        if(s.equals("a")) {
            return n;
        }

        if(!s.contains("a")) {
            return 0;
        }

        int aInS = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') {
                aInS++;
            }
        }

        long aConter = (n / s.length()) * aInS;
        for(int i = 0; i < n % s.length(); i++) {
            if(s.charAt(i) == 'a') {
                aConter++;
            }
        }

        return aConter;
    }
}
