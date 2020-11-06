import java.util.ArrayList;
import java.util.Collections;

public class NextLargestNumber {

    public static void main(String[] args) {

        System.out.println(nextNumber(19));
        System.out.println(nextNumber(3542));
        System.out.println(nextNumber(5432));
        System.out.println(nextNumber(58943));
        System.out.println(nextNumber(217));


    }

    public static int nextNumber(int num) {
        if(num < 10) {
            return num;
        }

        String strNum = Integer.toString(num);
        boolean isCorrect = true;

        for(int i = 0; i < strNum.length() - 1; i++) {
            if(Character.getNumericValue(strNum.charAt(i)) < Character.getNumericValue(strNum.charAt(i + 1))) {
                isCorrect = false;
                break;
            }
        }

        if(isCorrect) {
            return num;
        }

        if(num < 100) {
            return Integer.parseInt(strNum.charAt(1) + String.valueOf(strNum.charAt(0)));
        }

        ArrayList<Integer> digits = new ArrayList<>();

        for(int i = 0; i < strNum.length(); i++) {
            digits.add(Character.getNumericValue(strNum.charAt(i)));
        }

        Collections.sort(digits);

        StringBuilder result = new StringBuilder();
        int tempNum = 0;

        for(int i = strNum.length() - 1; i > 0; i--) {

            if(Character.getNumericValue(strNum.charAt(i)) > Character.getNumericValue(strNum.charAt(i - 1))) {

                result.append(strNum.substring(0, i - 1));

                for(int j = 0; j < result.length(); j++) {

                    if(digits.contains(Character.getNumericValue(result.charAt(j)))) {
                        digits.remove(Integer.valueOf(Character.getNumericValue(result.charAt(j))));
                    }
                }


                for(int j = 0; j < digits.size(); j++) {

                    if(digits.get(j) > Character.getNumericValue(strNum.charAt(i - 1))) {
                        tempNum = digits.get(j);
                        digits.remove(j);
                        break;
                    }
                }

                result.append(tempNum);

                if(i == strNum.length() - 2) {
                    break;
                }

                break;
            }
        }

        for(int i = 0; i < digits.size(); i++) {
            result.append(digits.get(i));
        }

        return Integer.parseInt(result.toString());
    }
}
