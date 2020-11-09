public class CheckIfTheFormulaIsCorrect {

    public static void main(String[] args) {

        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));

    }

    public static boolean formula(String str) {
        str = str.replaceAll(" ", "");
        String[] strSplit = str.split("=");
        int result;
        int tempResult = 0;
        boolean isCorrect = true;


        if (str.contains("a")) {
            if(strSplit[0].contains("a") && strSplit[1].contains("a")) {
                return true;

            } else if(!strSplit[0].matches(".*\\d.*") || !strSplit[1].matches(".*\\d.*")) {
                return true;

            } else {
                if(strSplit[0].contains("a")) {
                    result = theResult(strSplit[1]);
                    String tempNum = "";
                    char symbol = '+';
                    for(int i = 0; i < strSplit[0].length(); i++) {
                        if(Character.isDigit(strSplit[0].charAt(i))) {
                            tempNum += strSplit[0].charAt(i);
                        } else if(strSplit[0].charAt(i) != 'a') {
                            symbol = strSplit[0].charAt(i);
                        }
                    }

                    if(symbol == '+' || symbol == '-' || symbol == '/') {
                        return true;
                    } else if(symbol =='*') {
                        if(result % Integer.parseInt(tempNum) == 0) {
                            return true;
                        }
                    }
                } else {
                    result = theResult(strSplit[0]);
                    String tempNum = "";
                    char symbol = '+';
                    for(int i = 0; i < strSplit[1].length(); i++) {
                        if(Character.isDigit(strSplit[1].charAt(i))) {
                            tempNum += strSplit[1].charAt(i);
                        } else if(strSplit[1].charAt(i) != 'a') {
                            symbol = strSplit[1].charAt(i);
                        }
                    }

                    if(symbol == '+' || symbol == '-' || symbol == '/') {
                        return true;
                    } else if(symbol =='*') {
                        if(result % Integer.parseInt(tempNum) == 0) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        result = theResult(strSplit[0]);


        for (int i = 1; i < strSplit.length; i++) {
            tempResult = theResult(strSplit[i]);

            if (result != tempResult) {
                isCorrect = false;
                break;
            }
        }

        return isCorrect;
    }

    public static int mathResult(int num1, int num2, char symbol) {
        if (symbol == '+') {
            return num1 + num2;

        } else if (symbol == '-') {
            return num1 - num2;

        } else if (symbol == '*') {
            return num1 * num2;

        } else {
            return num1 / num2;
        }
    }

    public static int theResult(String str) {
        int tempResult = 0;
        String tempNum = "";
        char symbol = '+';

        if (str.matches("[0-9]+")) {
            return Integer.parseInt(str);

        } else {
            int count = 0;

            for (int j = 0; j < str.length(); j++) {

                if (Character.isDigit(str.charAt(j))) {
                    tempNum += str.charAt(j);

                    if (j == str.length() - 1) {
                        return mathResult(tempResult, Integer.parseInt(tempNum), symbol);
                    }

                } else {
                    count++;

                    if (count == 1) {
                        tempResult += Integer.parseInt(tempNum);
                        tempNum = "";

                    } else {
                        tempResult = mathResult(tempResult, Integer.parseInt(tempNum), symbol);
                    }

                    symbol = str.charAt(j);
                }
            }
        }
        return mathResult(tempResult, Integer.parseInt(tempNum), symbol);
    }
}
