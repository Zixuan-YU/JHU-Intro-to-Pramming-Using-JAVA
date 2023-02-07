/* Course: [605.201.81] Introduction to Programming Using Java
 * Mini Project 1: Tortoise Hare Race
 * This program will simulate the Tortoise Hare Race along a horizontal course that has 60 positions.
 * For the tortoise, 50% of the time it will perform a fast plod (move forward 3 squares), 
 * 30% of the time it will perform  a slow plod if the number is 6-8 (move forward 1 squares),
 * 20% of the time it will perform  a slip (move backwards 6 squares).  
 * For the hare, 20% of the time it will perform  big hop (move forward 9 squares),
 * 30% of the time it will perform  a small hop (move forward 1 squares),
 * 10% of the time it will perform  a big slip (move backwards 12 squares),
 * 20% of the time it will perform  a small slip (move backwards 2 squares),
 * and it will fall asleep for the rest of 20% time (remain where it is).
 * The program will loop untile either of the contenders are at or passed the finish line
 * It will aslo display the round number, Tortoise's postion, and the Hare's location after each round.
 * When the two animals bump into each other, "OUCH!!" will be shown in their position
 * When either of them reach the destination, the program will annouce who is the winner
 * @author Zixuan Yu
 * @since 10/05/2022
 */

import java.util.Random;
import java.util.Arrays;

public class TortoiseHareRace
{
    public static int tortoise; // initialize tortoise
    public static int hare; // initialize hare
    public static char[] course = new char[61]; // initialize the horizontal course that contains 60 positions. 
    // index 1-60 position are used as course
    // index 0 position are used to draw the begining line 
    public static final Random rand = new Random(); // initialize the horizontal course that contains at 60 positions.

    public static void main(String[] args)
    {
        tortoise = 0;
        hare = 0;
        int roundNum = 0; // The number indicate how many round have the two animals moved
        Arrays.fill(course, ' ');
        System.out.println("3... 2... 1.. Start!");
        System.out.println("AND THEY’RE OFF!!");
        System.out.println();
        // loop until a winner has been determined
        while (!checkWinner()) { 
            System.out.println("Round " + roundNum + ": ");
            displayRace(); 	// invoke the displayRace() method to show the tortoise's location and the hare's location
            moveTortoise(); // invoke moveTortoise() method to move the tortoise
            moveHare(); // invoke moveHare() method to move the hare
            roundNum += 1;
            System.out.println("\n"); // Change to next line when each round finished

        }
        // examine who is the winner
        if ((tortoise >= 60)&& (hare >= 60))
        {
            System.out.println("IT’S A TIE!! ");
        }
        else if (tortoise >= 60) 
        {
            System.out.println("TORTOISE WINS!! UNBILIEVABLE! ");
        }
        else
        {
            System.out.println("HARE WINS!!");
        }
            
    }

    // this method allow us to check if there is already a winner
    public static boolean checkWinner() 
    {
        return ((tortoise >= 60) || (hare >= 60)); 
    }

    // display the tortoise's location and the hare's location
    public static void displayRace() 
    {
        Arrays.fill(course, ' '); // fill the course with by a spcaes
        String samePlace = "OUCH!!!"; // initialize the String "OUCH!!!"

        course[0] = '|';  // The startline
        course[60] = '|'; // The endline
        if (tortoise == hare) 
        // when the tortoise and the hare are in the same position, 
        // display the string "OUCH!!!" beginning from the tortoise's/hare's positon        
        {
            for (int j = 0; j < samePlace.length(); j++)
            {
                course[tortoise+1+j] = samePlace.charAt(j);
            }

        } else { 
            course[tortoise+1] = 'T'; // use +1 because we want both of them start at position 1
            course[hare+1] = 'H';
        }
        for (char chr : course) // print out the current race condition
            System.out.print(chr);
    }

    // This method allow us to simulate tortoise's movement
    public static void moveTortoise() 
    {
        int randomNum = rand.nextInt(10) + 1; // generate random integer number from 1-10
        int move;
        if ((randomNum >= 1) && (randomNum <= 5)) // fast plod
        {
            move =  3;
        }
        else if ((randomNum >= 6) && (randomNum <= 8)) // slow plod
        {
            move =  1;
        }
        else // slip
        {
            move =  -6;
        }
        tortoise = tortoise + move < 0 ? 0 : tortoise + move;  // avoid slipping back to before the start line 
    }

    // This method allow us to simulate hare's movement
    public static void moveHare() 
    {
        int randomNum = rand.nextInt(10) + 1;
        int move;
        if ((randomNum == 1) || (randomNum == 2)) // big hop
        {
            move =  9;
        }
        else if ((randomNum == 3) || (randomNum == 4) || (randomNum == 5)) // small hop
        {
            move =  1;
        }
        else if (randomNum == 6) // big slip
        {
            move =  -12;
        }
        else if ((randomNum == 7) || (randomNum == 8)) // small slip
        {
            move =  -2;
        }
        else // fall asleep
        {
            move =  0;
        }
        hare = hare + move < 0 ? 0 : hare + move; // avoid slipping back to before the start line 
    }
}