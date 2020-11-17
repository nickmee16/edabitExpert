import java.util.ArrayList;

public class ColumnarCipher {

    public static void main(String[] args) {

        System.out.println(cipher("Meet me by the lake at midnight. Bring shovel.", "python"));
        System.out.println(cipher("meeanbsleyamgioxebltirhxttkihnvxmhedtgex","monty"));
        System.out.println(cipher("Flight 1386 Gate 447 Contact November Bravo", "lockjaw"));

    }

    public static String cipher(String msg, String keyword) {
        String tempStr = msg.replaceAll("[^a-zA-Z0-9]", " ").replaceAll(" ", "").toLowerCase();
        ArrayList<String> words = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        if (tempStr.equals(msg)) {
            int l = tempStr.length() / keyword.length();
            ArrayList<Integer> index = new ArrayList<>();

            for (int i = 0; i < keyword.length(); i++) {
                words.add(tempStr.substring(i * l, l + i * l));
            }

            boolean isPossible = true;
            int temp = 123;
            int indexNum = 0;

            while (isPossible) {

                for (int i = 0; i < keyword.length(); i++) {

                    if ((int) keyword.charAt(i) < temp && !index.contains(i)) {
                        temp = keyword.charAt(i);
                        indexNum = i;
                    }
                }

                index.add(indexNum);

                if (keyword.length() == index.size()) {
                    isPossible = false;

                } else {
                    temp = 123;
                }
            }


            for (int i = 0; i < words.get(0).length(); i++) {
                for (int j = 0; j < index.size(); j++) {
                    int ele = index.get(j);
                    result.append(words.get(ele).charAt(i));
                }
            }

            return result.toString();
        }


        for (int i = 0; i < tempStr.length(); i += keyword.length()) {

            if (i + keyword.length() >= tempStr.length()) {
                StringBuilder temp = new StringBuilder(tempStr.substring(i));

                for (int j = 0; j < (i + keyword.length()) - tempStr.length(); j++) {
                    temp.append("x");
                }

                words.add(temp.toString());
                break;
            }

            words.add(tempStr.substring(i, i + keyword.length()));

        }


        boolean isPossible = true;
        int temp = 123;
        int indexNum = 0;

        while (isPossible) {

            for (int i = 0; i < keyword.length(); i++) {

                if ((int) keyword.charAt(i) < temp) {
                    temp = keyword.charAt(i);
                    indexNum = i;
                }
            }

            keyword = removeByIndex(keyword, indexNum);

            for (int i = 0; i < words.size(); i++) {
                result.append(words.get(i).charAt(indexNum));
                words.set(i, removeByIndex(words.get(i), indexNum));
            }

            if (words.get(0).equals("")) {
                isPossible = false;

            } else {
                temp = 123;
            }
        }

        return result.toString();
    }

    public static String removeByIndex(String str, int index) {
        return new StringBuilder(str).deleteCharAt(index).toString();
    }
}
