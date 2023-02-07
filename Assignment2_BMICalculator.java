/*
 * This programs is Assignment 2 Part 2 for course [605.201.81] Introduction to Programming Using Java
 * It will read the weight (in pounds) and the height (in inches) from user input, 
 * and then convert the weight to kiloggram and convert the height to meter to calculate the BMI
 * It will display the BMI and its corresponding catogeris, i.e. underweight, normal, overweight, or obese.
 * Author: Zixuan Yu
 * Date: 09/12/2022
 */ 


import java.util.Scanner;

public class BMICalculator
{
    public static void main( String [] args )
    {
        // Define and initialize variables for values to be input
        int weight = 0;      // weight to be input
        int height = 0;      // height to be input

        // Use a Scanner to input integer values
        Scanner input = new Scanner( System.in );
        System.out.println( "\n\n" );
        System.out.print( "Enter weight (pounds) and height (inches) separated by a blank space: " );
        weight = input.nextInt();     // Input weight
        height = input.nextInt();     // Input height

        
        // Convert the unit for BMI calculations
        double weight_kg = weight * 0.45359237; // Convert the weight from lb to kg
        double height_m = height * 0.0254; // Convert the height from inch to meter
        double bmi = weight_kg/height_m/height_m; // Calculate the sum of all 6 integers

        // Determine the BMI category
        String cat = "";  // Define and initialize the BMI category to be output

        if (bmi < 18.5) 
        {
            cat = "Underweight";
        } 
        else if (bmi < 24.9) 
        {
            cat = "Normal";
        } 
        else if (bmi < 29.9) 
        {
            cat = "Overweight";
        } 
        else 
        {
            cat = "Obese";
        }
        
        // Alternative way of writing: Using another indentation style
        /*
        if (bmi < 18.5) {
            cat = "Underweight";
        } else if (bmi < 24.9) {
            cat = "Normal";
        } else if (bmi < 29.9) {
            cat = "Overweight";
        } else {
            cat = "Obese";
        }
        */

        // Output using System.out.println()
        System.out.println( "\n\n" );
        System.out.println( "\t" + "The BMI is " + bmi + "kg/m^2." );
        System.out.println( "\t" + "As suggested by the Department of Health & Human Services/National Institutes, this BMI is " + cat );
        System.out.println( "\n\n" );
    }
}