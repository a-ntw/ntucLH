/*
Date and Time [java.time.*]
===========================
Get Current Date and Time
Difference between two given dates. or
Get the days Between Two Dates
Check if a given year is leap year or not?
convert date to EST/EDT timezone
calculate the age of a person based on Date of Birth 
calculate the day of week based on a given date 
Display a every date with 30 Days Interval for the next two years
 */

/**
 * https://docs.oracle.com/en/java/javase/15/docs/api/index.html
 *
 * @author antw
 */
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.time.LocalDate; // import the LocalDate class
import java.time.Year; // for checking of Leap Year
import java.time.Period;

public class javaTime {

    public static void myPr(String X) {
        System.out.println(X);
    }

    public static String scanInput() {
        System.out.print("?? ");
        String inputStr = System.console().readLine();
        return inputStr;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        LocalDate DoBirth = LocalDate.parse("1965-08-09"); // Date of birth

        myPr("\n ***********  java.time *************");
        System.out.print("Input date [yyyy-mm-dd]");
        String keyInDateStr = "2020-12-25";
        //String keyInDate = scanInput();

        LocalDateTime toDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedToDate = toDateObj.format(myFormatObj);
        myPr("Current Date and Time: " + formattedToDate + "\n");

        //default, ISO_LOCAL_DATE
        LocalDate keyInDateD = LocalDate.parse(keyInDateStr);
        myPr("This date: " + keyInDateD);
        LocalDate toDate = LocalDate.now();
        myPr("To date:   " + toDate + "\n");

        int dayDiffOfYear = keyInDateD.getDayOfYear() - toDate.getDayOfYear();
        myPr("Difference on this date " + keyInDateD + " and today "
                + toDate + " are " + dayDiffOfYear + " days away!\n");

        int yearOfDate = keyInDateD.getYear();

        boolean leapYear = (Year.isLeap(yearOfDate));
        /* Ternary Operator*/
        String printVal = leapYear ? "YES\n" : "NO\n";
        myPr("A given year," + yearOfDate + " is leap year? " + printVal);

        // myPr("convert date to EST/EDT timezone");  // KIV
        myPr("The age of a person based on date of birth " + DoBirth);
        Period ageFromDob = Period.between(DoBirth, toDate);
        myPr("are period " + ageFromDob + ", or "
                + ageFromDob.getYears() + " years.\n");

        DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        String formattedDate = keyInDateD.format(myFormatObj2);
        myPr("The day of week based on a given date: " + formattedDate + "\n");

        myPr("Display a every date with 30 Days Interval for the next two years");
        // java.time.chrono  // isBefore
        int daysToAdd = 30;
        int yearsToAdd = 2;
        LocalDate thirtyD = toDate.plusDays(daysToAdd);
        LocalDate yearsDaysDate = toDate.plusYears(yearsToAdd);
        do {
            myPr(" :: " + thirtyD);
            thirtyD = thirtyD.plusDays(daysToAdd);
        } while (thirtyD.isBefore(yearsDaysDate));
    }
}
