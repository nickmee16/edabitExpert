import java.util.Arrays;

public class FootballScores {

    public static void main(String[] args) {

        System.out.println(football(4));
        System.out.println(football(6));
        System.out.println(football(7));
        System.out.println(football(8));
        System.out.println(football(9));

    }

    public static int football(int score) {
        int[] table = new int[score + 1];
        int[] possibles = {2,3,6,7,8};

        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i < possibles.length; i++)
            for (int j = possibles[i]; j <= score; j++)
                table[j] += table[j - possibles[i]];

        return table[score];
    }
}

