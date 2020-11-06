public class PilishStrings {

    public static void main(String[] args) {

        System.out.println(pilish_string("FORALOOP"));
        System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
        System.out.println(pilish_string("ARANDOMSEQUENCEOFLETTERS"));

    }

    public static String pilish_string(String s) {
        if(s.equals("")) {
            return "";
        }

        String Pi = "314159265358979";
        StringBuilder result = new StringBuilder();
        int count = 0;
        int temp = 0;

        for(int i = 0; i < Pi.length(); i++) {

            for(int j = 0; j < Character.getNumericValue(Pi.charAt(i)); j++) {
                count++;
                char ch = s.charAt(temp + j);

                if(temp + j == s.length() - 1 && j != Character.getNumericValue(Pi.charAt(i)) - 1) {

                    for(int x = j; x < Character.getNumericValue(Pi.charAt(i)); x++) {
                        result.append(ch);
                    }
                    break;
                }
                result.append(ch);
            }

            if(count >= s.length()) {
                break;
            }

            result.append(" ");
            temp += Character.getNumericValue(Pi.charAt(i));
        }

        return result.toString().trim();
    }
}
