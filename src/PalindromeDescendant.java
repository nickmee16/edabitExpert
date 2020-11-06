public class PalindromeDescendant {

    public static void main(String[] args) {

        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(13001120));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
        System.out.println(palindromeDescendant(1122));

    }

    public static boolean palindromeDescendant(int num) {
        String strNum = Integer.toString(num);
        String temp = "";
        boolean isPalindrome = true;

        for (int i = 0; i < strNum.length() / 2; i++) {
            if (strNum.charAt(i) != strNum.charAt(strNum.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            return true;
        }

        boolean isPossible = true;

        while (isPossible) {

            for (int i = 0; i < strNum.length() - 1; i += 2) {
                temp += (Character.getNumericValue(strNum.charAt(i)) + Character.getNumericValue(strNum.charAt(i + 1)));
            }

            if (temp.length() == 1) {
                break;
            }

            for (int i = 0; i < temp.length() / 2; i++) {
                if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                    strNum = temp;
                    temp = "";
                    break;
                }
            }

            if (!temp.equals("")) {
                isPalindrome = true;
                isPossible = false;
            }
        }

        return isPalindrome;
    }
}
