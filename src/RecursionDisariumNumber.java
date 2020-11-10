public class RecursionDisariumNumber {

    public static void main(String[] args) {

        System.out.println(isDisarium(75));
        System.out.println(isDisarium(135));
        System.out.println(isDisarium(516));
        System.out.println(isDisarium(518));
        System.out.println(isDisarium(8));

    }

    public static boolean isDisarium(int n) {
        return theResult(Integer.toString(n), 0, 1);
    }

    public static boolean theResult(String num, int result, int count) {
        result += Math.pow(Character.getNumericValue(num.charAt(count - 1)), count);

        if(count == num.length()) {
            if(result == Integer.parseInt(num)) {
                return true;
            }

            return false;
        }

        count++;
        return theResult(num, result, count);
    }
}
