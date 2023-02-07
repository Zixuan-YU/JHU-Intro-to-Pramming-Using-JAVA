/* 
 * This program will catch the NullPointerException and display an error message 
 * indicating that the details of this exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - NullPointerExceptionCatch 
 * Date: 10/30/2022
 */
public class NullPointerExceptionCatch
{
    public static void main( String [] args )
    {   
        try
        {
            // declare String myString and let it be null
            String myString = null;
            // when we are assessing the null object myString, the NullPointerException 
            // will be triggered 
            System.out.println(myString.length());
        } catch (NullPointerException e)
        {
            System.out.println(e);
            System.out.println("This code block will handle the NullPointerException" +
                    " error gracefully. This error will occur when an application" +
                    " attempts to use null in a case where an object is required: \n" +
                    " (1) we are accessing or modifying the field of a null object; \n " +
                    "(2) Calling the instance method of a null object; \n" +
                    " (3) Taking the length of null as if it were an array; \n" +
                    " (4) Accessing or modifying the slots of null as if it were an array; \n" +
                    " (5) Throwing null as if it were a Throwable value; etc. \n" +
                    " The code after this code block will still run. ");
        }
    
    } // end main
} // end NullPointerExceptionCatch
