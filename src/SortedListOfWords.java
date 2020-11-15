public class SortedListOfWords {

    public static void main(String[] args) {

        System.out.println(isSorted(new String[] {"hello", "edabitlot"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isSorted(new String[] {"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isSorted(new String[] {"ornggrqho", "qjcbnhnax", "bamnch", "sujmxeu", "szjoxirq", "luvgiu", "tkramy", "vhi", "ahjl", "dpm"}, "xiujyowcqbkslgrhzftnmvadep"));

    }

    public static boolean isSorted(String[] w, String l) {
        boolean isCorrect = true;


        for(int i = 0; i < w.length - 1; i++) {
            int temp1 = l.indexOf(w[i].charAt(0));
            int temp2 = l.indexOf(w[i + 1].charAt(0));

            if(temp1 > temp2) {
                isCorrect = false;

            } else if(temp1 == temp2) {

                for(int j = 0; j < w[i].length(); j++) {

                    if(j == w[i + 1].length()) {
                        isCorrect = false;
                        break;
                    }

                    temp1 = l.indexOf(w[i].charAt(j));
                    temp2 = l.indexOf(w[i + 1].charAt(j));

                    if(temp1 > temp2) {
                        isCorrect = false;
                        break;

                    } else if(temp1 < temp2) {
                        break;
                    }
                }
            }


            if(!isCorrect) {
                break;
            }
        }

        return isCorrect;
    }
}
