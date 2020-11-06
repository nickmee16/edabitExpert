public class RecursionPronicNumber {

    public static void main(String[] args) {

        System.out.println(isHeteromecic(0));
        System.out.println(isHeteromecic(2));
        System.out.println(isHeteromecic(7));
        System.out.println(isHeteromecic(110));
        System.out.println(isHeteromecic(136));
        System.out.println(isHeteromecic(156));

    }

    public static boolean isHeteromecic(int n) {
        return check(n, 0);
    }

    public static boolean check(int n, int count) {
        if(count * (count + 1) == n) {
            return true;
        } else if(count * (count + 1) > n) {
            return false;
        } else {
            count = count + 1;
            return check(n, count);
        }
    }
}
