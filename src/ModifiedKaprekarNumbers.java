public class ModifiedKaprekarNumbers {

    public static void main(String[] args) {

        System.out.println(kaprekarNumbers(1, 10));
        System.out.println(kaprekarNumbers(100, 300));
        System.out.println(kaprekarNumbers(1, 100));
        System.out.println(kaprekarNumbers(1, 99999));
        System.out.println(kaprekarNumbers(2, 4));

    }

    public static String kaprekarNumbers(int p, int q) {
        String strNum;
        int d;
        String strTempNum;
        String result = "";

        for(int i = p; i <= q; i++) {
            strNum = Integer.toString(i);
            d = strNum.length();
            strTempNum = Long.toString((long) Math.pow(i, 2));

            if(d * 2 == strTempNum.length() || (d * 2) - 1 == strTempNum.length()) {

                if(strTempNum.length() == 1) {
                    if(Integer.parseInt(strTempNum) == i) {
                        result += strNum + " ";
                    }
                }

                if(strTempNum.length() % 2 == 0) {
                    if(Long.parseLong(strTempNum.substring(0, strTempNum.length() / 2)) + Long.parseLong(strTempNum.substring(strTempNum.length() / 2)) == i) {
                        result += strNum + " ";
                    }
                } else if(strTempNum.length() > 2 && i % 10 != 0) {
                    if(Long.parseLong(strTempNum.substring(0, strTempNum.length() / 2)) + Long.parseLong(strTempNum.substring(strTempNum.length() / 2)) == i) {
                        result += strNum + " ";
                    } else if(Long.parseLong(strTempNum.substring(0, strTempNum.length() / 2 + 1)) + Long.parseLong(strTempNum.substring(strTempNum.length() / 2 + 1)) == i) {
                        result += strNum + " ";
                    }
                }
            }
        }

        if(result.equals("")) {
            return "INVALID RANGE";
        }
        return result.trim();
    }
}
