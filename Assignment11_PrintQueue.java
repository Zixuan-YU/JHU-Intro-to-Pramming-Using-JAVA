
/* Course: [605.201.81] Introduction to Programming Using Java
* Module11: Collections, Wrappers, and Generics - Part 2
* This program will mimic a Queue using LinkedArray. User can add a job to the queue
* until he want to stop. When he choose to stop and quit, the program will print the 
* current job queue including the job number, and time estimate (random number) to the 
* screen. The jobs are a first-in-first-out (FIFO) waiting line model or queue.
* Date: 11/14/2022
* Author: Zixuan Yu
*/
import java.util.*;

import javax.lang.model.util.ElementScanner14;

import java.lang.*;

public class PrintQueue {

    public static void main(String[] args) {

        // initialized the LinkedList to store queue
        LinkedList<String> myQueue = new LinkedList<>();

        int choice; // initialize int representing user's choice
        int i = 0; // initialize job count/job#
        Scanner input = new Scanner(System.in); // Initiate new scanner for user inputs

        do {
            // display prompt to ask user what to do, 1-4

            System.out.println("What would you like to do? ");
            System.out.println("Enter '1' to add a job ");
            System.out.println("Enter '0' to quit and print the queue ");
            System.out.print("Selection: ");

            choice = input.nextInt();
            input.nextLine(); // flush the scanner for \n

            if (choice == 1) {
                Random rnGenerator = new Random(); // creates a Random object
                int printTime = rnGenerator.nextInt(1000) + 10; // next int in range 10-1000
                Job job = new Job(printTime, i);
                myQueue.add(job.toString());
                System.out.println("Added job number " + i + " to the Printer Queue. \n");
                i++; // increment i
            }

        } while (choice != 0);

        // check if the queue is empty
        if (myQueue.size() == 0) {
            System.out.println("The Print Queue is empty! ");
        } else {
            // if not empty, print the current queue
            for (String s : myQueue) {
                System.out.println(s + "\n");
            }
        }

    }
}

// Create the Job calss to strore jobs
class Job {
    // initializing class variables privately
    private int time;
    private int id;

    // constructor with all parameters
    Job(int time, int id) {
        this.time = time;
        this.id = id;

    }

    // Assigning variables
    // set time
    public void setTime(int time) {
        this.time = time;
    }

    // set id
    public void setID(int id) {
        this.id = id;
    }

    // get method: for returning variables
    // get time
    public int getTime() // return time
    {
        return time;
    }

    // get id
    public int getID() // return id
    {
        return id;
    }

    // return the job's job number and printtime
    public String toString() {
        return ("Job#" + this.id + "  PrintTime: " + this.time + " secs ");
    }

}