public class ReverseWordsInAString {

    public static void main(String[] args) {

        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));

    }

    public static String reverseWords(String s) {
        String[] sSplit = s.split(" ");
        String result = "";

        for(int i = sSplit.length - 1; i >= 0; i--) {
            if(!sSplit[i].equals("")) {
                result += sSplit[i] + " ";
            }
        }

        return result.trim();
    }
}
