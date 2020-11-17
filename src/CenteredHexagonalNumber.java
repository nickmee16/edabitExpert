public class CenteredHexagonalNumber {

    public static void main(String[] args) {

        System.out.println(hexLattice(2));


    }

    public static String hexLattice(int n) {

        StringBuilder str = new StringBuilder();
        if (n == 1) {
            return " o ";
        }

        if ((n - 1) % 6 != 0) {
            return "Invalid";
        }

        boolean isCorrect = true;

        int top_bottom_num = 0;

        for (int i = 0; i < n; i++) {
            if (1 + 6 * (i * (i - 1)) / 2 == n) {
                top_bottom_num = i;
                break;
            } else if(1 + 6 * (i * (i - 1)) / 2 > n) {
                isCorrect = false;
                break;
            }
        }

        if(!isCorrect) {
            return "Invalid";
        }

        int middleNum = n;

        for (int i = 0; i < 100; i++) {
            if (middleNum > ((top_bottom_num + i) * 2)) {
                middleNum = middleNum - ((top_bottom_num + i) * 2);
            } else {
                break;
            }
        }

        for (int top = top_bottom_num; top < middleNum; top++) {
            for (int i = 0; i < middleNum - top; i++) {
                str.append(" ");
            }

            for (int i = 0; i < top; i++) {
                str.append(" o");
            }

            for (int i = 0; i <= middleNum - top; i++) {
                str.append(" ");
            }
            str.append("\n");
        }

        for (int i = 0; i < middleNum; i++) {
            str.append(" o");
        }
        str.append(" \n");

        for (int bot = middleNum - 1; bot >= top_bottom_num; bot--) {
            for (int i = 0; i < middleNum - bot; i++) {
                str.append(" ");
            }

            for (int i = 0; i < bot; i++) {
                str.append(" o");
            }

            for (int i = 0; i <= middleNum - bot; i++) {
                str.append(" ");
            }
            if(bot != top_bottom_num) {
                str.append("\n");
            }
        }


        return str.toString();
    }
}

