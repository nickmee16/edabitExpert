public class RecursionConsecutiveNumberSeries {

    public static void main(String[] args) {

        System.out.println(isConsecutive("121314151617"));
        System.out.println(isConsecutive("123124125"));
        System.out.println(isConsecutive("32332432536"));
        System.out.println(isConsecutive("326325324323"));
        System.out.println(isConsecutive("667666"));

    }

    public static boolean isConsecutive(String s) {
        return theResult(s, 1);
    }

    public static boolean theResult(String s, int count) {
        boolean isCorrect = true;

        if(count == s.length() / 2 + 1) {
            return false;
        }

        if(s.length() % count == 0) {
            for(int i = 0; i < s.length() - count; i += count) {
                if(Integer.parseInt(s.substring(i, i + count)) + 1 !=  Integer.parseInt(s.substring(i + count, i + count + count))) {
                    isCorrect = false;
                    break;
                }
            }

            if(isCorrect) {
                return true;
            }

            isCorrect = true;

            for(int i = 0; i < s.length() - count; i += count) {
                if(Integer.parseInt(s.substring(i, i + count)) - 1 !=  Integer.parseInt(s.substring(i + count, i + count + count))) {
                    isCorrect = false;
                    break;
                }
            }

            if(isCorrect) {
                return true;
            }
        }
        count++;
        return theResult(s, count);
    }
}
