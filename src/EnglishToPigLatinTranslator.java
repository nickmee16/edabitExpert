import java.util.regex.Pattern;

public class EnglishToPigLatinTranslator {

    public static void main(String[] args) {

//        System.out.println(translateWord("flag"));
//        System.out.println(translateWord("Apple"));
//        System.out.println(translateWord("button"));
//        System.out.println(translateWord(""));
//        System.out.println(translateSentence("I like to eat honey waffles."));
//        System.out.println(translateSentence("Do you think it is going to rain today?"));
        System.out.println(translateSentence("He said, \"When will this all end?\""));

    }

    public static String translateWord(String word) {
        if(word.equals("")) {
            return "";
        }

        if(Character.toLowerCase(word.charAt(0)) != 'a'
        && Character.toLowerCase(word.charAt(0)) != 'e'
        && Character.toLowerCase(word.charAt(0)) != 'u'
        && Character.toLowerCase(word.charAt(0)) != 'i'
        && Character.toLowerCase(word.charAt(0)) != 'o') {
            String temp = "";
            boolean hasUppercase = (Character.isUpperCase(word.charAt(0)));

            for(int i = 0; i < word.length(); i++) {
                if(Character.toLowerCase(word.charAt(i)) != 'a'
                        && Character.toLowerCase(word.charAt(i)) != 'e'
                        && Character.toLowerCase(word.charAt(i)) != 'u'
                        && Character.toLowerCase(word.charAt(i)) != 'i'
                        && Character.toLowerCase(word.charAt(i)) != 'o') {
                    temp += Character.toLowerCase(word.charAt(i));
                } else {
                    if(hasUppercase) {
                        return Character.toUpperCase(word.charAt(i)) + word.substring(i + 1) + temp + "ay";
                    } else {
                        return word.substring(i) + temp + "ay";
                    }
                }
            }

            return word.substring(1) + word.charAt(0) + "ay";
        }
        return word + "yay";
    }

    public static String translateSentence(String sentence) {
        String[] sentenceSplit = sentence.split(" ");
        String result = "";
        int index = 0;
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);


        for(int i = 0; i < sentenceSplit.length; i++) {
            if(p.matcher(sentenceSplit[i]).find()) {
                for(int j = 0; j < sentenceSplit[i].length(); j++) {
                    if(!Character.isLetter(sentenceSplit[i].charAt(j))
                            && j < sentenceSplit[i].length() / 2
                    && Character.isLetter(sentenceSplit[i].charAt(i + 1))) {
                        index = j;
                        break;
                    } else if(!Character.isLetter(sentenceSplit[i].charAt(j))
                            && j > sentenceSplit[i].length() / 2) {
                        index = j;
                        break;
                    }
                }

                if(index < sentenceSplit[i].length() / 2) {
                    System.out.println("i was here");
                    result += sentenceSplit[i].substring(0, index + 1) + translateWord(sentenceSplit[i].substring(index + 1)) + " ";
                } else {
                    result += translateWord(sentenceSplit[i].substring(0, index)) + sentenceSplit[i].substring(index) + " ";
                }
            } else {
                result += translateWord(sentenceSplit[i]) + " ";
            }
        }

        return result.trim();
    }
}
