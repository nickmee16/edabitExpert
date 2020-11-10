import java.math.BigInteger;
import java.security.MessageDigest;

public class GetSHA256Hash {

    public static void main(String[] args) {

        System.out.println(getSha256Hash("hi"));
        System.out.println(getSha256Hash("password123"));

    }

    public static String getSha256Hash(String input)  {
        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }
}
