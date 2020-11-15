public class RecursionTheOutShuffle {

    public static void main(String[] args) {

        System.out.println(shuffleCount(8));
        System.out.println(shuffleCount(14));
        System.out.println(shuffleCount(52));

    }

    public static int shuffleCount(int num) {
        int[] cards = new int[num];
        int[] cardsToShuff = new int[num];
        for(int i = 0; i < num; i++) {
            cards[i] = i + 1;
            cardsToShuff[i] = i + 1;
        }

        return theResult(cards, cardsToShuff, 0, num);
    }

    public static int theResult(int[] a, int[] b, int numShuufs, int num) {
        int count = 0;
        int temp;
        for(int i = 0; i < num - 1; i += 2) {
            temp = b[num/2 + i - count];
            for(int j = num/2 + i - count; j > i + 1; j--) {
                b[j] = b[j - 1];
            }
            b[i + 1] = temp;
            count++;
        }

        boolean isCorrect = true;
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                isCorrect = false;
                break;
            }
        }
        numShuufs++;

        if(isCorrect) {
            return numShuufs;
        } else {
            return theResult(a, b, numShuufs, num);
        }
    }
}