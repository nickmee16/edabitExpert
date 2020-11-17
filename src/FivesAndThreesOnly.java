public class FivesAndThreesOnly {

    public static void main(String[] args) {

        System.out.println(only5and3(14));
        System.out.println(only5and3(25));
        System.out.println(only5and3(7));

    }

    public static boolean only5and3(int num) {
        if(num < 3) {
            return false;
        }

        if(num % 5 == 0) {
            return true;
        }

        int result = 1;
        int tempResult;
        boolean isCorrect = false;

        for(int i = 0; i < num; i++) {
            result *= 3;

            if(result > num) {
                break;
            }

            if(result == num) {
                isCorrect = true;
                break;
            }

            tempResult = result;
            for(int j = 0; j < num; j++) {
                tempResult += 5;

                if(tempResult == num) {
                    isCorrect = true;
                    break;
                }

                if(tempResult > num) {
                    break;
                }
            }

            if(isCorrect) {
                break;
            }
        }

        return isCorrect;
    }
}
