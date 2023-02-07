/* 
 * This program will Thrown the Array Index Out Of Bounds Exception and display an error message 
 * indicating that the details of the exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - ArrayIndexOutOfBounds 
 * Date: 10/25/2022
 */
public class ArrayIndexOutOfBoundsThrown
{
    public static void main( String [] args ) 
    {   
        // Create the list containing 3 words
        String [] arr = new String [] {"Apple", "Banana", "Cherry"};
        
        /* loop through each integer in the list
        Since index 3 is out of the index range of the array, 
        it will throw an ArrayIndexOutOfBounds Exception
        */
        try
        {
            loopThru(arr);
        }
        finally
        {
            System.out.println("This program can compile and the code in finally will run anyway.");
        }
        
    } // end main

    // This method will loop through the array and throw an ArrayIndexOutOfBoundsException
    public static void loopThru(String [] myArray ) throws ArrayIndexOutOfBoundsException
    {
        for ( int i = 0; i <= 3 ; i++)
        {   
            String allFruit = "";
            if ((i >= 3) || ( i <= 0))
            {
                throw new ArrayIndexOutOfBoundsException("the index must be less or equal than three. \n" +
                "This code block will handle the Array index out of bounds" +
                " error gracefully, it will throw an ArrayIndexOutOfBoundsException when " +
                " the array does not have the specified index. The index is either not " +
                " positive, or greater than or equal to the size of the array. \n" );
            } else
            {
                allFruit = allFruit + myArray[i]; //concatenated all String
            }
        }
    } // end loopThru

} // end ArrayIndexOutOfBounds
