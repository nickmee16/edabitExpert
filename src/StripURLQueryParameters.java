import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StripURLQueryParameters {

    public static void main(String[] args) {

        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", null));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));

    }

    public static String stripUrlParams(String url, String[] paramsToStrip) {
        if (!url.contains("?")) {
            return url;
        }

        String theSubStr = url.substring(url.indexOf('?') + 1);
        String[] theSubStrSplit = theSubStr.split("&");

        ArrayList<String> queryParameters = new ArrayList<>(Arrays.asList(theSubStrSplit));


        if (paramsToStrip != null) {

            for (int i = 0; i < queryParameters.size(); i++) {

                for (int j = 0; j < paramsToStrip.length; j++) {

                    if (String.valueOf(queryParameters.get(i).charAt(0)).equals(paramsToStrip[j])) {
                        queryParameters.remove(i);
                        i--;
                        break;
                    }
                }

            }
        }


        for (int i = 0; i < queryParameters.size(); i++) {

            for (int j = i + 1; j < queryParameters.size(); j++) {

                if (queryParameters.get(i).charAt(0) == queryParameters.get(j).charAt(0)) {
                    queryParameters.remove(i);
                    i--;
                    break;
                }
            }
        }


        Collections.sort(queryParameters);
        StringBuilder result = new StringBuilder(url.substring(0, url.indexOf('?') + 1));

        for (int i = 0; i < queryParameters.size(); i++) {
            if (i == queryParameters.size() - 1) {
                result.append(queryParameters.get(i));
            } else {
                result.append(queryParameters.get(i)).append("&");
            }
        }


        return result.toString();
    }
}
