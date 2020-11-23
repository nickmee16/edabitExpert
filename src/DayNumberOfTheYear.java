import java.text.ParseException;
import java.util.ArrayList;

public class DayNumberOfTheYear {

    public static void main(String[] args) throws ParseException {

        System.out.println(dayOfYear("12/13/2020"));
        System.out.println(dayOfYear("12/17/2020"));
        System.out.println(dayOfYear("11/16/2020"));
        System.out.println(dayOfYear("01/09/2019"));

    }

    public static int dayOfYear(String date) {

        int year = Integer.parseInt(date.substring(6));
        boolean isLeapYear = (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0));

        ArrayList<Integer> daysInMonth = new ArrayList<>();
        daysInMonth.add(31);
        if(isLeapYear) {
            daysInMonth.add(29);
        } else {
            daysInMonth.add(28);
        }

        daysInMonth.add(31);
        daysInMonth.add(30);
        daysInMonth.add(31);
        daysInMonth.add(30);
        daysInMonth.add(31);
        daysInMonth.add(31);
        daysInMonth.add(30);
        daysInMonth.add(31);
        daysInMonth.add(30);
        daysInMonth.add(31);

        int result = Integer.parseInt(date.substring(3,5));
        int l = Integer.parseInt(date.substring(0,2)) - 1;

        for(int i = 0; i < l; i++) {
            result += daysInMonth.get(i);
        }

        return result;
    }


//    public static long dayOfYear(String date) throws ParseException {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//        Date firstDate = sdf.parse("01/00/" + date.substring(6));
//        Date secondDate = sdf.parse(date);
//
//        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
//
//        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//    }
}
