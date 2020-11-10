import java.util.Arrays;
import java.util.Comparator;

public class StringCleaver {

    public static void main(String[] args) {

        String[] words = {"a", "after", "all", "an", "and", "are", "as",
                "by", "continued", "deadlines", "doubly", "fish", "for", "go", "happen",
                "happened", "i", "illusion", "is", "long", "love", "lunchtime", "make",
                "moment", "noise", "nothing", "of", "or", "people", "problem", "second",
                "so", "summarize", "summary", "thanks", "the", "then", "they", "time",
                "to", "whooshing"};

        System.out.println(cleave("solongandthanksforallthefish", words));
        System.out.println(cleave("solongandthanksforalllthefish", words));
        System.out.println(cleave("tosummarizethesummaryofthesummarypeopleareaproblem", words));
        System.out.println(cleave("timeisanillusionlunchtimedoublyso", words));
        System.out.println(cleave("ilovedeadlinesilovethewhooshingnoisetheymakeastheygoby", words));
        System.out.println(cleave("ilovedeadlinesilovethewheezingnoisetheymakeastheygoby", words));
        System.out.println(cleave("foramomentnothinghappenedthenafterasecondorsonothingcontinuedtohappen", words));


    }

    public static String cleave(String str, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        int num = words[0].length();
        String temp = "";
        StringBuilder result = new StringBuilder();
        boolean isCorrect = true;

        for (int i = 0; i < str.length(); i++) {
            temp += str.charAt(i);

            if (i == str.length() - 1 && !checkWord(temp, words)) {
                isCorrect = false;
                break;
            }

            if (temp.length() > num) {
                isCorrect = false;
                break;
            }

            if (checkWord(temp, words)) {

                if (i != str.length() - 1) {

                    for (int j = 0; j < words.length; j++) {
                        if (temp.length() < words[j].length()
                                && words[j].startsWith(temp)
                                && words[j].equals(str.substring(i - temp.length() + 1, i - temp.length() + 1 + words[j].length()))) {
                            i = i - temp.length() + words[j].length();

                            String anotherTemp = "";
                            boolean shit = true;

                            for (int x = i + 1; x < str.length(); x++) {
                                anotherTemp += str.charAt(x);

                                if (checkWord(anotherTemp, words)) {
                                    break;
                                }

                                if (anotherTemp.length() > num) {
                                    shit = false;
                                    break;
                                }
                            }

                            if (!shit) {
                                i = i + temp.length() - words[j].length();
                                break;
                            }

                            temp = words[j];

                        }
                    }
                }

                result.append(" ").append(temp);
                temp = "";
            }
        }

        if (!isCorrect) {
            return "Cleaving stalled: Word not found";
        }

        return result.toString().trim();
    }

    public static boolean checkWord(String str, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        if (str.length() > words[0].length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(str)) {
                return true;
            }
        }

        return false;
    }
}
