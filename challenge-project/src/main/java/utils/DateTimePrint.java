package utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimePrint {
    public static void printDateTimeNow(){
        // Get the current date and time in the system's default time zone
        // This is often GMT+7 in Vietnam
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());

        // Define the new desired format: "yyyy/MM/dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        // Format the ZonedDateTime object and print
        String formattedDateTime = now.format(formatter);
        System.out.println(formattedDateTime);
    }
    public static String getDateDateTimeNow(){
        // Get the current date and time in the system's default time zone
        // This is often GMT+7 in Vietnam
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());

        // Define the new desired format: "yyyy/MM/dd HH:mm:ss"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        // Format the ZonedDateTime object and print
        return now.format(formatter);
    }

}
