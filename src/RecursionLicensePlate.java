public class RecursionLicensePlate {

    public static void main(String[] args) {

        System.out.println(licensePlate("5F3Z-2e-9-w", 4));
        System.out.println(licensePlate("2-5g-3-J", 2));
        System.out.println(licensePlate("2-4A0r7-4k", 3));
        System.out.println(licensePlate("nlj-206-fv", 3));

    }

    public static String licensePlate(String code,int group) {
        code = code.replaceAll("-", "").toUpperCase();
        int length = code.length() - 1;
        int count = 1;

        return theCode(code, group, length, count, "");
    }

    public static String theCode(String code, int group, int length, int count, String result) {

        if(length == 0) {
            result = code.charAt(length) + result;
            return result;

        } else if(count % group == 0) {
            result = "-" + code.charAt(length) + result;
            length--;
            count++;
            return theCode(code, group, length, count, result);

        } else {
            result = code.charAt(length) + result;
            length--;
            count++;
            return theCode(code, group, length, count, result);
        }
    }
}
