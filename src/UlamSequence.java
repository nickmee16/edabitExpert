public class UlamSequence {

    public static void main(String[] args) {

        System.out.println(ulam(9));
        System.out.println(ulam(206));

    }

    public static int ulam(int n) {
        if(n < 5) {
            return n;
        }

        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;

        int number = 5;
        int temp = 5;
        int count;

        for(int i = 4; i < nums.length; i++) {
            boolean isPossible = true;

            while (isPossible) {
                count = 0;
                for(int x = 0; x < temp - 1; x++) {

                    for(int y = x + 1; y < temp; y++) {

                        if(nums[x] + nums[y] == number) {
                            count++;
                        }
                        if(count == 2) {
                            break;
                        }
                    }

                    if(count == 2) {
                        break;
                    }
                }

                if(count == 1) {
                    temp++;
                    isPossible = false;
                } else {
                    number++;
                }
            }

            nums[i] = number;

        }

        return nums[n - 1];
    }
}
