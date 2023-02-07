/* 
 * This program will catch the Array Index Out Of Bounds Exception and display an error message 
 * indicating that the details of the exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - ArrayIndexOutOfBounds 
 * Date: 10/25/2022
 */
public class ArrayIndexOutOfBoundsCatch
{
    public static void main( String [] args )
    {   
        // Create the list containing 5 integegers
        int [] arr = new int [] {100, 200, 300, 400, 500};

        try
        {
            /* loop through each integer in the list
            Since index 5 is out of the index range of the array, 
            it will trigger an array index out of bounds error
            */
            for ( int i = 0; i <= 5 ; i++)
            {
                System.out.println("Array index value: " + arr[i] + " at index " + i); 
                // Print a blank line between each Item
            }  
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
            System.out.println("This code block will handle the Array index out of bounds" +
                    " error gracefully. it will catch an ArrayIndexOutOfBoundsException when " +
                    " the array does not have the specified index. The index is either not " +
                    " positive, or greater than or equal to the size of the array. \n" +
                    " The code after this code block will still run. ");
        } finally
        {
            System.out.println("This program can compile and the code in finally will run anyway.");
        }
    
    } // end main
} // end ArrayIndexOutOfBounds
