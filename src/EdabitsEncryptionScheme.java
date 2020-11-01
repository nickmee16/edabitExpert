public class EdabitsEncryptionScheme {

    public static void main(String[] args) {

//        System.out.println(encryption("if man was meant to stay on the ground god would have given us roots"));
//        System.out.println(encryption("haveaniceday"));
//        System.out.println(encryption("feedthedog"));
//        System.out.println(encryption("chillout"));
//        System.out.println(encryption("A Fool and His Money Are Soon Parted."));
        System.out.println(encryption("One should not worry over things that have already happened and that cannot be changed."));


    }

    public static String encryption(String s) {
        String str = "";

        if(s.contains(" ")) {

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != ' ') {
                    str += s.charAt(i);
                }
            }
        } else {
            str = s;
        }

        int L = str.length();
        int smallL = 0;

        if(Math.sqrt(L) != (int) Math.sqrt(L)) {
            smallL = (int) Math.sqrt(L) + 1;
        } else {
            smallL = (int) Math.sqrt(L);
        }

        int row = 0;
        int column = 0;

        for(int i = 1; i <= smallL; i++) {
            boolean gotValues = false;

            for(int j = 1; j <= smallL; j++) {
                if(i * j >= L) {
                    row = i;
                    column = j;
                    gotValues = true;
                    break;
                }
            }

            if(gotValues) {
                break;
            }
        }

        String result = "";
        int diff = (row * column) - L;

        for(int i = 0; i < column; i++) {

            for(int j = 0; j < row; j++) {

                if(i + diff >= column) {
                    if((i + 1) * (j + 1) > (row * (i + 1)) - (L % column) ) {
                        break;
                    }
                }
                result += str.charAt(i + j * column);
            }

            if(i != column - 1) {
                result += " ";
            }
        }


        return result;
    }
}
