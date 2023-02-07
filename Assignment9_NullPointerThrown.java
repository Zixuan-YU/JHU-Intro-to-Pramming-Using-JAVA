/* 
 * This program will thrown the NullPointerException and display an error message 
 * indicating that the details of this exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - public class NullPointerExceptionThrown 
 * Date: 10/30/2022
 */
public class NullPointerExceptionThrown
{
    public static void main( String [] args )
    {   
        try
        {
            NullExFunc(null);
            // when we are passing null to a method, the NullPointerException will be triggered 
        } 
        finally
        {
            System.out.println("This program can compile and the code in 'finally' will run anyway.");      
        }
    
    } // end main

    // creating a function will pring out the uppercase string if the input argument is not null
    // indivating it would through NullPointerException if the input is null
    public static void NullExFunc(String myString) throws NullPointerException
    {
        if (myString != null)
        {
            System.out.println(myString.toUpperCase()); // This will conver myString to the 
        }
        else // throw an NullPointerException if the value is null
        {
            throw new NullPointerException("The argument of this function cannot be null. \n" +
            "This NullPointerException will occur when an application attempts to use null" +
            "in a case where an object is required: \n" +
            " (1) we are accessing or modifying the field of a null object; \n " +
            "(2) Calling the instance method of a null object; \n" +
            " (3) Taking the length of null as if it were an array; \n" +
            " (4) Accessing or modifying the slots of null as if it were an array; \n" +
            " (5) Throwing null as if it were a Throwable value; etc. \n" );
        }    
    }
} // end NullPointerExceptionThrown
