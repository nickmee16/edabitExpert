public class RecursionMultiplicationByAddition {

    public static void main(String[] args) {

        System.out.println(multiply(10, 2));
        System.out.println(multiply(-54, -4));
        System.out.println(multiply(3, 9));
        System.out.println(multiply(-21, 5));
        System.out.println(multiply(273, -6));

    }

    public static int multiply(int x, int y) {
        if(x < 0 && y < 0) {
            x = x * -1;
            y = y * -1;
        } else if(y < 0) {
            x = x * -1;
            y = y * -1;
        }

        return theResult(x, 0, 1, y);
    }

    public static int theResult(int x, int result, int count, int y) {
        result += x;
        if(count == y) {
            return result;
        } else {
            count++;
            return theResult(x, result, count, y);
        }
    }
}
