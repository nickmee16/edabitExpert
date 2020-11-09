import java.util.Arrays;

public class RecursionInclusiveArrayRanges {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(inclusiveArray(0, 5)));

    }

    public static int[] inclusiveArray(int startNum,int endNum) {

        if(endNum <= startNum) {
            return new int[]{startNum};
        }

        return nums(startNum, endNum, 0, new int[endNum - startNum + 1]);
    }

    public static int[] nums(int startNum,int endNum, int count, int[] numsArr) {

        if(startNum + count < endNum) {
            numsArr[count] = startNum + count;
            count++;
            return nums(startNum, endNum, count, numsArr);

        } else {
            numsArr[count] = startNum + count;
            return numsArr;
        }
    }
}
