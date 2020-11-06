public class MinimumStepsТoАPalindrome {

    public static void main(String[] args) {

        System.out.println(minPalindromeSteps("race"));
        System.out.println(minPalindromeSteps("mada"));
        System.out.println(minPalindromeSteps("mirror"));
        System.out.println(minPalindromeSteps("maa"));
        System.out.println(minPalindromeSteps("madam"));
    }

    public static int minPalindromeSteps(String str) {
        boolean isCorrect = true;
        for(int i = 0; i < str.length() / 2; i++) {

            if(str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                System.out.println(str.charAt(0));
                System.out.println(str.charAt(str.length() - 1 - i));
                isCorrect = false;
                break;
            }
        }

        if(isCorrect) {
            return 0;
        }

        String prefix = "";
        String temp;
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            prefix = str.charAt(i) + prefix;
            count++;
            temp = str + prefix;
            isCorrect = true;

            for(int j = 0; j < temp.length() / 2; j++) {

                if(temp.charAt(j) != temp.charAt(temp.length() - 1 - j)) {
                    isCorrect = false;
                    break;
                }
            }

            if(isCorrect) {
                break;
            }
        }

        return count;
    }
}
