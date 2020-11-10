import java.util.Arrays;

public class RollTheDice {

    public static void main(String[] args) {

        System.out.println(diceRoll(1, 3));
        System.out.println(diceRoll(2, 5));
        System.out.println(diceRoll(4, 18));
        System.out.println(diceRoll(6, 20));

    }

    public static int diceRoll(int n, int outcome) {
        if (n < 1 || outcome < n ) {
            return 0;
        }

        int[][] mem = new int[n][outcome];

        for (int[] mi : mem) {
            Arrays.fill(mi, 0);
        }

        return whatAreTheOddsRec(outcome, n, mem);
    }

    private static int whatAreTheOddsRec(int sum, int dices, int[][] mem) {
        if (dices <= 1) {
            return 1;
        }

        int n = 0;
        int dicesRem = dices - 1;
        int minFace = Math.max(sum - 6 * dicesRem, 1);
        int maxFace = Math.min(sum - dicesRem, 6);

        for (int i = minFace; i <= maxFace; i++) {
            int sumRem = sum - i;
            int ni = mem[dicesRem][sumRem];

            if (ni <= 0) {
                ni = whatAreTheOddsRec(sumRem, dicesRem, mem);
                mem[dicesRem][sumRem] = ni;
            }
            n += ni;
        }
        return n;
    }
}
