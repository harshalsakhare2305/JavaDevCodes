package CoreJava;

//import java.util.Date;

//import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTime {
    public static void main(String[] args) {
        // In java for date time we have two packages  -> using util,sql
//
//          Date date =new Date();
//        System.out.println(date);
//        int dayofMonth=date.getDay();
//        int month=date.getMonth();
//                int year =date.getYear();
//        System.out.println(dayofMonth+" / "+month+" / "+year);

    // we have use the date using the sql package as well but these two method are now depreciated



        //After Java 8 joda api is been introduced for the Data time

        LocalDate date = LocalDate.now();
        System.out.println(date);
        int day = date.getDayOfMonth();
        int month =date.getMonthValue();
        int year =date.getYear();

        System.out.println(day+" / "+month+" / "+year);

        LocalDate date2 =LocalDate.of(2004,05,23);
        System.out.println(date2);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        int hours =time.getHour();
        int minutes=time.getMinute();
        int second =time.getSecond();
        System.out.println(hours+" :: "+minutes+" :: "+second);

        LocalDateTime datetime =LocalDateTime.now();
        System.out.println(datetime);

    }
}
