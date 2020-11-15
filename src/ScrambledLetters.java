import java.util.Arrays;

public class ScrambledLetters {

    public static void main(String[] args) {

    }

    public static String[] scrambled(char[] letters, String[] dict, String mask) {
        StringBuilder words = new StringBuilder();
        boolean isCorrect;

        for (int i = 0; i < dict.length; i++) {

            if (dict[i].length() == mask.length()) {
                isCorrect = true;

                for (int j = 0; j < mask.length(); j++) {

                    if (Character.isLetter(mask.charAt(j)) && mask.charAt(j) != dict[i].charAt(j)) {
                        isCorrect = false;
                        break;
                    }
                }

                if (isCorrect) {
                    words.append(dict[i]).append(" ");
                }
            }

        }

        String[] wordsSplit = words.toString().trim().split(" ");
        Arrays.sort(wordsSplit);

        return wordsSplit;
    }
}
