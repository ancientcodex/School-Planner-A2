import Data.*;
import Data.Class;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.LocalTime;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {


        LocalTime localTime = new LocalTime(11,10,0);
        System.out.println(localTime);

        Interval interval = new Interval(new DateTime(2013, 10, 25, 8, 0, 0, 0), new DateTime(2013, 10, 25, 10, 0, 0, 0));
        Interval interval2 = new Interval(new DateTime(2013, 10, 25, 9, 0, 0, 0), new DateTime(2013, 10, 25, 9, 30, 0, 0));


      //  System.out.println(interval2.overlaps(interval));








    }
}