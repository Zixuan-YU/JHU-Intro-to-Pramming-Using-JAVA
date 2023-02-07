
/* Course: [605.201.81] Introduction to Programming Using Java
* Module4 Program2: Year Calendar
* This program will prompt the user to enter a month (1-12) and a 4-digit year (e.g., 2012),
* and then displays a calendar for that month and year
* Author: Zixuan Yu
* Date: 09/26/2022
*/ 

import java.util.Scanner;

public class YearCalendar
{
    public static void main( String [] args )
    {
        // Define and initialize variables for values to be input
        int m;      // value for the month (1-12)
        int y;      // value for the year (4-digit year number)
        int d;      // value for the day in the month
        // Use a Scanner to input integer values
        Scanner input = new Scanner( System.in );
        System.out.println( "\n\n" );
        System.out.print( "Enter 4-digit year number (e.g., 2012): " );
        y = input.nextInt();     // Input the 4-digit year number, e.g. 2012
        printYearCalendar( y );
        //printMonthCalendar( m, y );
    }    

    public static void printYearCalendar( int y ) 
    {   
        int d = 1;
        for (int m = 1; m<=12; m++) // Loop through the first month to the 12th month
        {
            printMonthHeader(m, y); // Invoke the method to print monthly calendar header
            printMonthBody(m, y, d); // Invoke the method to print monthly calendar body
        }
        
    }

    public static void printMonthCalendar( int m, int y ) 
    {   
        // int startdate = getStartDay(m, d, y);
        // int numdays = getNumDaysInMonth(m, y);
        int d = 1;
        printMonthHeader(m, y); // Invoke the method to print calendar header
        printMonthBody(m, y, d);  // Invoke the method to print calendar body
    }

    // Displays the header information ( month, year, line separator, 3-character day names) for a calendar.
    public static void printMonthHeader( int m, int y)
    {
        String monthname = getMonthName(m);
        System.out.println(String.format("%-29s", "         " + monthname + "  " + y));
        // Make sure this line will occupy 29 spaces
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
    }

    // Displays the days in the calendar associated with the corresponding days of the week.
    public static void printMonthBody( int m, int y, int d) 
    {
        int startdate = getStartDay(m, d, y); // Get the weekday of the first day of the user specified month
        int numdaysinmonth = getNumDaysInMonth(m, y); // Get the number days in the user specified month
        int i;
        d = 1;

        for (i = 0; i < (startdate % 7); i++) 
        {
            System.out.print("    ");
        }
        for (i = 1; i <= numdaysinmonth; i++)
        {
            System.out.print(String.format("%1$4s", i));

            if ( (i + startdate) % 7 == 0 )
            {
                System.out.print("\n");
            }
        }
        System.out.println("\n");
    
    }

    // Returns the name of the month for a specified month number (e.g., returns March for m=3). 

    public static String getMonthName(int m)
    {
        String mname = "";
        switch (m)
        {
            case 1: 
                mname = "January";
                break;
            case 2: 
                mname = "February";
                break;
            case 3: 
                mname = "March";
                break;
            case 4: 
                mname = "April";
                break;
            case 5: 
                mname = "May";
                break;
            case 6: 
                mname = "June";
                break;
            case 7: 
                mname = "July";
                break;
            case 8: 
                mname = "August";
                break;
            case 9: 
                mname = "September";
                break;
            case 10: 
                mname = "October";
                break;
            case 11: 
                mname = "November";
                break;
            case 12: 
                mname = "December";
        }
        return mname;
    }



    /* Returns the day of week number (1=Monday,…, 7= Sunday) for the specified month, day, and year. 
    Note this only works for the 1st day of the month. */

    public static int getStartDay( int m, int d, int y )
    {
        // Adjust month number & year to fit Zeller's numbering system
        if (m < 3) 
        {
            m = m + 12;
            y = y - 1;
        }
        
        int k = y % 100;      // Calculate year within century
        int j = y / 100;      // Calculate century term
        int h = 0;            // Day number of first day in month 'm'
        
        h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) +
            ( 5 * j ) ) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ( ( h + 5 ) % 7 ) + 1;     
        
        return dayNum;
    }



    // Returns the number of days in a specified month and year. Leap years are accounted for.
    public static int getNumDaysInMonth( int m, int y)
    {
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
        {
            return 31;  //Jan, Mar, May, July, Aug, Oct, and Dec has 31 days    
        }
        else if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            return 30;  //Apr, June, Sept, and Nov has 31 days    
        }
        else if (m == 2) 
        {
            if (isLeapYear(y)) // Test if the user specified year is a leap year
                return 29;   // For leap year, February has 29 days
            else 
                return 28;   // If not leap year, February has 28 days
        } 
        else // If the user does not enter 1-12
        {
            System.out.println("Invalid input! Please enter integer numbers 1-12");
            return 0;
        }
                   
        
    }

    public static boolean isLeapYear( int y ) 
    {
        if ( (y % 4 == 0 && y % 100 != 0 ) || (y % 400 == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}