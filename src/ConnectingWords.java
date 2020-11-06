import java.util.Arrays;

public class ConnectingWords {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(join(new String[]{"happy", "python", "honey", "yelp", "plank", "lanky"})));

    }

    public static String[] join(String[] letters) {
        String result = letters[0];
        int length = 0;
        int minLetters = letters[0].length();

        for(int i = 0; i < letters.length - 1; i++) {
            length = letters[i].length();

            for(int j = 0; j < length; j++) {

                if(j == length - 1 && !letters[i].substring(j).equals(letters[i + 1].substring(0, length - j))) {
                    result += letters[i + 1];
                    minLetters = 0;

                } else if(length - j <= letters[i + 1].length() && letters[i].substring(j).equals(letters[i + 1].substring(0, length - j))) {
                    result += letters[i + 1].substring(length - j);

                    if(minLetters > length - j) {
                        minLetters = length - j;
                    }
                    break;
                }
            }

        }

        return new String[]{result, Integer.toString(minLetters)};
    }
}
