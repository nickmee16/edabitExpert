public class Syllabification {

    public static void main(String[] args) {

        System.out.println(syllabification("tesh"));
        System.out.println(syllabification("kAr"));
        System.out.println(syllabification("bArAn"));
        System.out.println(syllabification("tA"));
        System.out.println(syllabification("deraxt"));
        System.out.println(syllabification("pust"));
        System.out.println(syllabification("lAjevard"));

    }

    public static String syllabification(String word) {
        return word.replaceAll("(?<!^)([^aAieou][aAeiou])", ".$1");
    }
}
