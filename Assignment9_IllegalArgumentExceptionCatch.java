/* 
 * This program will catch the IllegalArgumentException and display an error message 
 * indicating that the details of this exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - IllegalArgumentExceptionCatch 
 * Date: 10/30/2022
 */
public class IllegalArgumentExceptionCatch
{
    public static void main(String[] args)
    {
        int myScore = 101;
        try 
        {
            checkScoreValidity(myScore); // this will trigger the IllegalArgumentException
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
            System.out.println("This code block will handle the IllegalArgumentException gracefully." +
                    " The error will occur when an illegal or inappropriate argument is passed to " +
                    " the method. For example, passing extra variables or passing integer value " +
                    " when a String is needed, , or the entered integer is out of required range. \n" +
                    " The code after this code block will still run. ");            
        }
        finally
        {
            System.out.println("This program can compile and the code in 'finally' will run anyway.");            
        }  
    } // end main

    // a method that would check the validity of the score
    public static void checkScoreValidity(int score) throws IllegalArgumentException
    {
        // Score must be 0 to 100 (inclusive)
        if (score < 0 || score > 100) 
        {
        throw new IllegalArgumentException("IllegalArgumentException: Score can only be between 0-100");
        }
    }
} // end IllegalArgumentExceptionCatch


