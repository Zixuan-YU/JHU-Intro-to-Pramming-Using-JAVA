/*
 * This programs is Assignment 2 Part 1 for course [605.201.81] Introduction to Programming Using Java
 * It will read 6 integers from user input and then display them in a 3 rows by 2 columns format
 * It will produce row sums and columns sums and display the sums
 * Author: Zixuan Yu
 * Date: 09/12/2022
 */ 


import java.util.Scanner;

public class AddValues
{
    public static void main( String [] args )
    {
        // Define and initialize variables for values to be input
        int v1 = 0;      // First value to be input
        int v2 = 0;      // Second value to be input
        int v3 = 0;      // Third value to be input
        int v4 = 0;      // Fourth value to be input
        int v5 = 0;      // Fifth value to be input
        int v6 = 0;      // Sixth value to be input

        // Use a Scanner to input integer values
        Scanner input = new Scanner( System.in );
        System.out.println( "\n\n" );
        System.out.print( "Enter 6 integers separated by a blank space: " );
        v1 = input.nextInt();     // Input first value
        v2 = input.nextInt();     // Input second value
        v3 = input.nextInt();     // Input third value
        v4 = input.nextInt();     // Input fourth value
        v5 = input.nextInt();     // Input fifth value
        v6 = input.nextInt();     // Input sixth value
        
        // Calculate column sums and sum of all 6 integers to reduce output line width
        int colsum1 = v1 + v3 + v5; // Calculate sum for the first column
        int colsum2 = v2 + v4 + v6; // Calculate sum for the second column
        int allsum = v1 + v2 + v3 + v4 + v5 + v6; // Calculate the sum of all 6 integers

        // Output using System.out.println()
        System.out.println( "\n\n" );
        System.out.println( "\t" + "Value" + "\t" + "Value" + "\t" + "Total");
        System.out.println( "\t" + v1 + "\t" + v2 + "\t" + (v1 + v2) );
        System.out.println( "\t" + v3 + "\t" + v4 + "\t" + (v3 + v4) );
        System.out.println( "\t" + v5 + "\t" + v6 + "\t" + (v5 + v6) );
        System.out.println( "\t----\t----\t----" );
        System.out.println( "Total" + "\t" + colsum1 + "\t" + colsum2+ "\t" + allsum );
        System.out.println( "\n\n" );
    }
}