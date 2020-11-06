public class CenteredHexagonalNumber {

    public static void main(String[] args) {

        System.out.println(hexLattice(7));

    }
    //   o o o
    //  o o o o
    // o o o o o
    //  o o o o
    //   o o o

    public static String hexLattice(int n) {
        int length = 0;
        boolean isPossible = true;
        for (int i = 0; i < n; i++) {
            if (1 + 6 * (i * (i - 1)) / 2 == n) {
                length = i;
                break;
            }

            if (1 + 6 * (i * (i - 1)) / 2 > n) {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            return "Invalid";
        }

        String result = "";

        for(int i = 1, k = length, l = 2 * length - 1; i < length; i++, k--, l++) {
            for(int j = 0; j < 3 * length; j++) {

                if(j >= k && j <= l) {
                    result += "o ";

                } else {
                    result += " ";
                }
            }

            result += "\n";
        }

        for(int i = 0, k = 1, l = 3 * length - 2; i < length; i++, k++, l--) {

            for(int j = 0; j < 3 * length; j++) {
                if(j >= k && j <= l) {
                    result += "o";

                } else {
                    result += " ";
                }
            }

            result += "\n";
        }

        return result;
    }
}
