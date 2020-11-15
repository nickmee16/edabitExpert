import java.util.ArrayList;

public class RecursionHappyNumber {

    public static void main(String[] args) {

        System.out.println(isHappy(67));
        System.out.println(isHappy(89));
        System.out.println(isHappy(139));
        System.out.println(isHappy(1327));
        System.out.println(isHappy(2871));
        System.out.println(isHappy(3970));

    }

    public static boolean isHappy(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(n);

        return theResult(n, nums);
    }

    public static boolean theResult(int n, ArrayList<Integer> nums) {
        String strN = Integer.toString(n);
        int num = 0;

        for(int i = 0; i < strN.length(); i++) {
            num += Math.pow(Character.getNumericValue(strN.charAt(i)), 2);
        }

        if(num == 1) {
            return true;
        } else if(nums.contains(num)) {
            return false;
        } else {
            nums.add(num);
            return theResult(num, nums);
        }
    }
}
