public class RecursionHalveAndHalveAgain {

    public static void main(String[] args) {

//        System.out.println(halveCount(1324, 98));
//        System.out.println(halveCount(624, 8));
        System.out.println(halveCount(4123, 1));

    }

    public static int halveCount(int a,int b) {

        return counter((double) a / 2, b, 0);
    }

    public static int counter(double a, int b, int count) {

        if(a > b) {
            count++;
            return counter(a / 2, b, count);

        } else {
            return count;
        }
    }
}
