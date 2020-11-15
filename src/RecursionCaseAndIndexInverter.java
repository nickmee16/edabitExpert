public class RecursionCaseAndIndexInverter {

    public static void main(String[] args) {

    }

    public static String invert(String s) {
        return theResult(s, "", s.length() - 1);
    }

    public static String theResult(String s, String word, int count) {
        if(Character.isLowerCase(s.charAt(count))) {
            word += Character.toUpperCase(s.charAt(count));

        } else {
            word += Character.toLowerCase(s.charAt(count));
        }

        if(count == 0) {
            return word;

        } else {
            count--;
            return theResult(s, word, count);
        }
    }
}
