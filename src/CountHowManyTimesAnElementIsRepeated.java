import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountHowManyTimesAnElementIsRepeated {

    public static void main(String[] args) {

    }

    public static Map<Object, Integer> countRepititions(Object[] e) {
        ArrayList<Object> elements = new ArrayList<>();
        Map<Object, Integer> counts = new HashMap<>();
        int count;

        for(int i = 0; i < e.length; i++) {

            if(!elements.contains(e[i])) {
                elements.add(e[i]);
                count = 0;

                for(int j = i; j < e.length; j++) {
                   if(e[i] == e[j]) {
                       count++;
                   }
                }

               counts.put(e[i], count);
            }
        }

        return counts;
    }
}
