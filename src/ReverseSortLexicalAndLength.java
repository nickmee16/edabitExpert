import java.util.Arrays;
import java.util.Comparator;

public class ReverseSortLexicalAndLength {

    public static void main(String[] args) {

        System.out.println(reverseSort("You've rocked the pragmatic world in the making!"));
        System.out.println(reverseSort("Tesh makes my world worth enjoying and living for."));
        System.out.println(reverseSort("Shaken by the bloody truth and crazy lies."));
        System.out.println(reverseSort("Java streams and collections are fun to program with!"));
        System.out.println(reverseSort("Lexical sort is similar to alphanumeric sorting."));
        System.out.println(reverseSort("To do or not to do, is all up to you."));

    }

    public static String reverseSort(String str) {
        String[] strSplit = str.split(" ");

        for(int i = strSplit.length - 1; i > 0; i--) {

            for (int j = i - 1; j >= 0; j--) {

                if (strSplit[i].toLowerCase().compareTo(strSplit[j].toLowerCase()) > 0) {
                    String temp = strSplit[i];
                    strSplit[i] = strSplit[j];
                    strSplit[j] = temp;
                }
            }
        }

        Arrays.sort(strSplit, Comparator.comparingInt(String::length).reversed());

        String result = "";

        for(int i = 0; i < strSplit.length; i++) {
            result += strSplit[i] + " ";
        }

        return result.trim();
    }
}
