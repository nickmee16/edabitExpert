public class ExcelSheetColumnNumber {

    public static void main(String[] args) {

        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("R"));
        System.out.println(titleToNumber("AB"));

    }

    public static int titleToNumber(String s) {
        int totalLetters = 26;
        int result = 0;

        for(int i = 0; i < s.length(); i++) {

            if((s.length() - 1) - i == 0) {
                result += ((int) s.charAt(i) - (int) 'A' + 1);

            } else {
                result += ((int) s.charAt(i) - (int) 'A' + 1) * Math.pow(totalLetters , (s.length() - 1) - i);
            }
        }

        return result;
    }
}
