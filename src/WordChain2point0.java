import java.util.ArrayList;

public class WordChain2point0 {

    public static void main(String[] args) {

        System.out.println(isWordChain(new String[]{"row", "crow", "crown", "brown", "brawn"}));
        System.out.println(isWordChain(new String[]{"meek", "meet", "meat", "teal"}));

    }

    public static boolean isWordChain(String[] words) {
        ArrayList<Character> letters1 = new ArrayList<>();
        ArrayList<Character> letters2 = new ArrayList<>();

        for (int i = 0; i < words[0].length(); i++) {
            letters1.add(words[0].charAt(i));
        }

        boolean isCorrect = true;
        int countDiff;

        for (int i = 1; i < words.length; i++) {

            if(words[i].length() > letters1.size() + 1) {
                isCorrect = false;
                break;
            }

            countDiff = 0;
            
            for (int j = 0; j < words[i].length(); j++) {
                letters2.add(words[i].charAt(j));
            }

            if(letters1.size() < letters2.size()) {

                for (int j = 0; j < letters1.size(); j++) {
                    if(letters1.get(j) != letters2.get(j + countDiff)) {
                        j--;
                        countDiff++;
                    }

                    if (countDiff > 1) {
                        break;
                    }
                }

            } else if(letters1.size() > letters2.size()) {

                for (int j = 0; j < letters2.size(); j++) {
                    if(letters1.get(j + countDiff) != letters2.get(j)) {
                        j--;
                        countDiff++;
                    }

                    if (countDiff > 1) {
                        break;
                    }
                }

            } else {
                for (int j = 0; j < letters1.size(); j++) {
                    if(letters1.get(j) != letters2.get(j)) {
                        countDiff++;
                    }

                    if (countDiff > 1) {
                        break;
                    }
                }
            }

            if (i != words.length - 1) {
                letters1.clear();
                letters2.clear();
                for (int j = 0; j < words[i].length(); j++) {
                    letters1.add(words[i].charAt(j));
                }
            }


            if (countDiff > 1) {
                isCorrect = false;
                break;
            }
        }

        return isCorrect;
    }
}
