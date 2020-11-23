public class RecursionPalindromePhrase {

    public static void main(String[] args) {

        System.out.println(isPalindrome("Go hang a salami, I'm a lasagna hog!"));
        System.out.println(isPalindrome("This phrase, surely, is not a palindrome!"));
        System.out.println(isPalindrome("Eva, can I see bees in a cave?"));

    }

    public static boolean isPalindrome(String p) {
        p = p.replaceAll("[^a-zA-Z0-9]","").replaceAll(" ", "").toLowerCase();

        return theResult(p, 0);
    }

    public static boolean theResult(String p, int count) {
        if(count == p.length() / 2 - 1) {
            if(p.charAt(count) == p.charAt(p.length() - 1 - count)) {
                return true;
            } else {
                return false;
            }
        } else if(p.charAt(count) == p.charAt(p.length() - 1 - count)) {
            count++;
            return theResult(p, count);
        } else {
            return false;
        }
    }
}
