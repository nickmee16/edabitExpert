import java.util.Arrays;

public class WordBuckets {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(bucketize("she sells sea shells by the sea", 10)));
        System.out.println(Arrays.toString(bucketize("the mouse jumped over the cheese", 7)));
        System.out.println(Arrays.toString(bucketize("fairy dust coated the air", 20)));
        System.out.println(Arrays.toString(bucketize("a b c d e", 2)));

    }

    public static String[] bucketize(String phrase, int n) {
        String[] phraseSplit = phrase.split(" ");
        boolean isLarger = false;
        String temp = "";
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < phraseSplit.length; i++) {

            if(phraseSplit[i].length() > n) {
                isLarger = true;
                break;
            }

            if(phraseSplit[i].length() + temp.length() < n) {
                temp += phraseSplit[i] + " ";

            } else if(phraseSplit[i].length() + temp.length() == n) {
                temp += phraseSplit[i];

            } else {
                result.append(temp.trim()).append(",");
                temp = phraseSplit[i] + " ";
            }

            if(i == phraseSplit.length - 1) {
                result.append(temp.trim());
            }
        }

        if(isLarger) {
            return new String[0];
        }

        return result.toString().split(",");
    }
}
