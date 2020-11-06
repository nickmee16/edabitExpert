import java.util.ArrayList;
import java.util.Collections;

public class SherlockAndTheValidString {

    public static void main(String[] args) {

        System.out.println(isValid("abccc"));

    }

    public static String isValid(String str) {
        ArrayList<Character> letters = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            letters.add(str.charAt(i));
        }

        Collections.sort(letters);
        int count;
        String numberOfAppearance = "";

        for(int i = 0; i < letters.size(); i++) {
            count = 0;

            for(int j = i; j < letters.size(); j++) {

                if(j == letters.size() - 1) {
                    if(letters.get(i) != letters.get(j)) {
                        i = j - 1;
                        break;

                    } else {
                        count++;
                        i = j;
                    }

                } else if(letters.get(i) != letters.get(j)) {
                    i = j - 1;
                    break;

                } else {
                    count++;
                }
            }

            numberOfAppearance += count;
        }

        int frequencyCount = 0;
        int temp = 0;
        count = 0;

        for(int i = 0; i < numberOfAppearance.length() - 1; i++) {
            count = 1;

            for(int j = i + 1; j < numberOfAppearance.length(); j++) {
                if(numberOfAppearance.charAt(i) == numberOfAppearance.charAt(j)) {
                    count++;
                }
            }

            if(count > temp) {
                temp = count;
                frequencyCount = Character.getNumericValue(numberOfAppearance.charAt(i));
            }

            if(temp > numberOfAppearance.length() / 2) {
                break;
            }
        }

        count = 0;
        boolean isCorrect = true;

        for(int i = 0; i < numberOfAppearance.length(); i++) {

            if(Character.getNumericValue(numberOfAppearance.charAt(i)) == frequencyCount + 1) {
                count++;
            }

            if(count > 1) {
                isCorrect = false;
            }

            if(Character.getNumericValue(numberOfAppearance.charAt(i)) < frequencyCount || Character.getNumericValue(numberOfAppearance.charAt(i)) > frequencyCount + 1) {
                isCorrect = false;
            }
        }

        if(isCorrect) {
            return "YES";
        }

        return "NO";
    }
}
