import java.util.ArrayList;

public class RecursionFlattenTheCurves {

    public static void main(String[] args) {

    }

    public static Object[] flatten(Object[] r) {
        ArrayList<Object> newStuff = new ArrayList<>();
        ArrayList<Object> objects = checkArr(r, newStuff);
        Object[] objectArr = new Object[objects.size()];

        for(int i = 0; i < objectArr.length; i++) {
            objectArr[i] = objects.get(i);
        }

        return objectArr;
    }

    public static ArrayList<Object> checkArr(Object[] arr, ArrayList<Object> objects) {

        for(int i = 0; i < arr.length; i++) {

            if(arr[i].getClass().isArray()) {
                checkArr((Object[]) arr[i], objects);
            } else {
                if(!arr[i].equals("") && !arr[i].equals(" ")) {
                    objects.add(arr[i]);
                }
            }
        }

        return objects;
    }
}
