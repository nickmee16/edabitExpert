public class RepeatingDecimalsТoFractions {

    public static void main(String[] args) {

        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("2.1(313)"));


    }

    public static String fractions(String decimal) {
        String inParentheses = "";
        for(int i = 0; i < decimal.length(); i++) {

            if(decimal.charAt(i) == '(') {
                for(int j = i + 1; j < decimal.length(); j++) {

                    if(decimal.charAt(j) == ')') {
                        break;
                    } else {
                        inParentheses += decimal.charAt(j);
                    }

                }
            }
        }

        int dotIndex = decimal.indexOf('.');

        StringBuilder decimalBuilder = new StringBuilder(decimal.replaceAll("[()]", ""));
        while (decimalBuilder.substring(dotIndex).length() < 16) {
            decimalBuilder.append(inParentheses);
        }
        decimal = decimalBuilder.toString();

        double num = Double.parseDouble(decimal);
        int num1 = 2;
        int num2 = 3;
        String result = "";


        if(num < 1) {

            for(int i = 1; i <= num1; i++) {

                for(int y = i + 1; y <= num2; y++) {

                    if(Double.toString((double) i / y).length() >= 14) {

                        if(decimal.substring(0, 14).equals(Double.toString((double) i / y).substring(0, 14)) ) {

                            result = i + "/" + y;
                            break;
                        }
                    }

                    if(num > (double) i / y) {
                        break;
                    }
                    num2++;
                }
                if(!result.equals("")) {
                    break;
                }

                num1++;
            }
        }

        for(int i = 1; i <= num1; i++) {

            for(int y = i - 1; y > 0; y--) {

                if(Double.toString((double) i / y).length() >= 14) {

                    if(decimal.substring(0, 14).equals(Double.toString((double) i / y).substring(0, 14)) ) {

                        result = i + "/" + y;
                        break;
                    }
                }

                if(num < (double) i / y) {
                    break;
                }
            }
            if(!result.equals("")) {
                break;
            }
            num1++;
        }


        return result;
    }
}
