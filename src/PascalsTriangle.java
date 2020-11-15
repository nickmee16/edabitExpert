public class PascalsTriangle {

    public static void main(String[] args) {

        System.out.println(pascalsTriangle(4));

    }

    public static String pascalsTriangle(int row) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= row; i++) {
            result.append(binomialCoeff(row, i)).append(" ");
        }

        return result.toString().trim();
    }

    static int binomialCoeff(int n, int k) {
        int res = 1;

        if (k > n - k)
            k = n - k;

        for (int i = 0; i < k; i++) {

            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }
}
