public class ReverseCodingChallenge {

    public static void main(String[] args) {

        System.out.println(method(14));
        System.out.println(method(1));
        System.out.println(method(2));
        System.out.println(method(3));
        System.out.println(method(15));
        System.out.println(method(134));
        System.out.println(method(3246));

    }

    public static Object method(int n) {
        int p = 0;

        while (n > 0) {
            p += (n % 2 == 0) ? 1 : -1;
            n /= 10;
        }

        if(p == 0) {
            return null;

        } else if(p < 0) {
            return false;
        }

        return true;
    }
}
