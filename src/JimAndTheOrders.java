import java.util.ArrayList;
import java.util.Arrays;

public class JimAndTheOrders {

    public static void main(String[] args) {

        int[][] arg = new int[5][5];
        arg[0][0] = 8;
        arg[0][1] = 1;
        arg[1][0] = 4;
        arg[1][1] = 2;
        arg[2][0] = 5;
        arg[2][1] = 6;
        arg[3][0] = 3;
        arg[3][1] = 1;
        arg[4][0] = 4;
        arg[4][1] = 3;

        System.out.println(Arrays.toString(jimOrders(arg)));

    }

    public static int[] jimOrders(int[][] orders) {
        int[] calculations = new int[orders.length];
        int temp;

        for(int i = 0; i < orders.length; i++) {
            temp = 0;

            for(int j = 0; j < orders[i].length; j++) {
                temp += orders[i][j];
            }

            calculations[i] = temp;
        }

        ArrayList<Integer> order = new ArrayList<>();
        int index = 0;
        boolean isPossible = true;

        while (isPossible) {
            temp = Integer.MAX_VALUE;

            for (int i = 0; i < calculations.length; i++) {

                if (temp > calculations[i] && !order.contains(i + 1)) {
                    temp = calculations[i];
                    index = i + 1;
                }
            }

            order.add(index);

            if(order.size() == calculations.length) {
                isPossible = false;
            }
        }

        int[] orderA = new int[order.size()];

        for(int i = 0; i < orderA.length; i++) {
            orderA[i] = order.get(i);
        }

        return orderA;
    }
}
