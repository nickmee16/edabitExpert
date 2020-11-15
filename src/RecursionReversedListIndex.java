import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RecursionReversedListIndex {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getItemsAt(new Object[]{"E","D","A","B","I","T"}, "even")));

    }

    public static Object[] getItemsAt(Object[] arr, String par) {
        int count = (par.equals("even")) ? 1 : 0;

        ArrayList<Object> elementsAL = theResult(arr, new ArrayList<>(), count);
        Collections.reverse(elementsAL);

        return elementsAL.toArray(new Object[0]);

    }

    public static ArrayList<Object> theResult(Object[] arr, ArrayList<Object> al, int count) {
        if(count >= arr.length) {
            return al;

        } else {
            al.add(arr[arr.length - 1 - count]);
            count += 2;

            return theResult(arr, al, count);
        }
    }
}
