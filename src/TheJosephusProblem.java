import java.util.ArrayList;

public class TheJosephusProblem {

    public static void main(String[] args) {

        System.out.println(josephus(41, 3));
        System.out.println(josephus(35, 11));
        System.out.println(josephus(11, 1));
        System.out.println(josephus(2, 2));

    }

    public static int josephus(int n, int x) {
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int count = 0;

        for(int i = 0; i < nums.size(); i++) {
            count++;

            if(count == x) {
                nums.remove(i);
                i--;
                count = 0;
            }

            if(nums.size() == 1) {
                break;
            }

            if(i == nums.size() - 1) {
                i = -1;
            }
        }

        return nums.get(0);
    }
}
