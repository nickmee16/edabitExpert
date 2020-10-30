import java.util.Arrays;

public class ShiritoriGame {

    public static void main(String[] args) {

        Shiritori my_shiritori = new  Shiritori();

        System.out.println(Arrays.toString(my_shiritori.play("apple")));
        System.out.println(Arrays.toString(my_shiritori.play("ear")));
        System.out.println(Arrays.toString(my_shiritori.play("rhino")));
        System.out.println(Arrays.toString(my_shiritori.play("corn")));
        System.out.println();
        System.out.println(Arrays.toString(my_shiritori.getWords()));
        System.out.println();
        System.out.println(my_shiritori.restart());
        System.out.println(Arrays.toString(my_shiritori.getWords()));
        System.out.println(Arrays.toString(my_shiritori.play("hostess")));
        System.out.println(Arrays.toString(my_shiritori.play("stash")));
        System.out.println(Arrays.toString(my_shiritori.play("hostess")));
    }


}

class Shiritori {
    private String[] words = new String[0];
    private boolean game_over;

    public Shiritori() {
        game_over = false;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public boolean isGame_over() {
        return game_over;
    }

    public void setGame_over(boolean game_over) {
        this.game_over = game_over;
    }

    public String[] play(String word) {
        if (words.length == 0) {
            words = Arrays.copyOf(words, words.length + 1);
            words[0] = word;
            return words;
        } else {
            boolean doesNotContain = true;

            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word)) {
                    doesNotContain = false;
                    break;
                }
            }

            if (words[words.length - 1].charAt(words[words.length - 1].length() - 1) == word.charAt(0) && doesNotContain) {
                words = Arrays.copyOf(words, words.length + 1);
                words[words.length - 1] = word;
                return words;
            } else {
                game_over = true;
                return new String[]{"game over"};
            }
        }
    }

    public String restart() {
        words = Arrays.copyOf(words, 0);
        game_over = false;
        return "game restarted";
    }

}