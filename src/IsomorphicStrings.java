public class IsomorphicStrings {

    public static void main(String[] args) {

        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("aba", "baa"));
        System.out.println(isIsomorphic("paper", "title"));

    }

    public static boolean isIsomorphic(String s, String t) {
        boolean isCorrect = true;

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == ch1 && t.charAt(j) != ch2) {
                    isCorrect = false;
                    break;
                }
            }

            if(!isCorrect) {
                break;
            }

            for(int j = 0; j < t.length(); j++) {
                if(t.charAt(j) == ch2 && s.charAt(j) != ch1) {
                    isCorrect = false;
                    break;
                }
            }

            if(!isCorrect) {
                break;
            }
        }

        return isCorrect;
    }
}
