

public class RecursionFindTheLongestWord {

    public static void main(String[] args) {

        System.out.println(findLongest("A thing of beauty is a joy forever."));
        System.out.println(findLongest("Forgetfulness is by all means powerless!"));
        System.out.println(findLongest("\"Strengths\" is the longest and most commonly used word that contains only a single vowel."));
        System.out.println(findLongest("The pretty daughter's toy, a doll, is as pretty as her."));

    }

    public static String findLongest(String sentence) {
        String[] sentenceSplit = sentence.replaceAll("[^a-zA-Z0-9]"," ").split(" ");
        return theResult("", 0, sentenceSplit);
    }

    public static String theResult(String word, int count, String[] sentence) {
        String temp = sentence[count].toLowerCase().trim();

        if(count == sentence.length - 1) {
            if(temp.length() > word.length()) {
                return temp;
            }

            return word;
        }

        if(temp.length() > word.length()) {
            word = temp;
        }

        count++;
        return theResult(word, count, sentence);
    }
}
