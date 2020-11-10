public class VigenereCipher {

    public static void main(String[] args) {

//        System.out.println(vigenere("Soylent Green is people.", "spoiler"));
//        System.out.println("KDMTPRKYGSMYMJHTCXWI");
        System.out.println(vigenere("HMRSSAIEKLSAXQILCCAC", "python"));

    }

    public static String vigenere(String text, String keyword) {

        if(!text.contains(" ")) {
            while (keyword.length() < text.length()) {
                keyword += keyword;
            }

            if(keyword.length() != text.length()) {
                keyword = keyword.substring(0, text.length()).toLowerCase();
            }

            keyword = keyword.toUpperCase();

            StringBuilder orig_text= new StringBuilder();

            for (int i = 0 ; i < text.length() && i < keyword.length(); i++) {
                int x = (text.charAt(i) - keyword.charAt(i) + 26) %26;
                x += 'A';
                orig_text.append((char) (x));
            }

            return orig_text.toString();
        }


        text = text.replaceAll(" ", "").replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        while (keyword.length() < text.length()) {
            keyword += keyword;
        }

        if(keyword.length() != text.length()) {
            keyword = keyword.substring(0, text.length()).toLowerCase();
        }
        keyword = keyword.toUpperCase();


        StringBuilder cipher_text = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int x = (text.charAt(i) + keyword.charAt(i)) % 26;
            x += 'A';

            cipher_text.append((char) (x));
        }

        return cipher_text.toString();
    }
}
