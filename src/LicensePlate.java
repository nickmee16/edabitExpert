public class LicensePlate {

    public static void main(String[] args) {

        System.out.println(licensePlate("5F3Z-2e-9-w", 4));
        System.out.println(licensePlate("2-5g-3-J", 2));
        System.out.println(licensePlate("2-4A0r7-4k", 3));
        System.out.println(licensePlate("nlj-206-fv", 3));

    }

    public static String licensePlate(String code, int group) {
        code = code.replaceAll("-", "");
        StringBuilder result = new StringBuilder();

        for(int i = code.length() - 1; i >= 0; i -= group) {

            for(int j = 0; j < group; j++) {

                if(i - j < 0) {
                    break;

                } else {
                    if(Character.isLetter(code.charAt(i - j))) {
                        result.insert(0, Character.toUpperCase(code.charAt(i - j)));

                    } else {
                        result.insert(0, code.charAt(i - j));
                    }
                }
            }

            if(i - group < 0) {
                break;
            }

            result.insert(0, "-");
        }

        return result.toString();
    }
}
