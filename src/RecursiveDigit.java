public class RecursiveDigit {

    public static void main(String[] args) {

        System.out.println(superDigit("99999999999999999999999999", 104500));

    }

    public static int superDigit(String n, int k) {
        int num = 0;

        for (int i = 0; i < n.length(); i++) {
            num += Character.getNumericValue(n.charAt(i));
        }

        num = num * k;

        return theResult(Integer.toString(num));
    }

    public static int theResult(String strNum) {
        int num = 0;

        for (int i = 0; i < strNum.length(); i++) {
            num += Character.getNumericValue(strNum.charAt(i));
        }

        if (num < 10) {
            return num;
        }
        return theResult(Integer.toString(num));
    }
}
