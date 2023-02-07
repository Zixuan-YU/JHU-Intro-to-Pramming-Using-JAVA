/* 
 * This program will throw the IllegalArgumentException and display an error message 
 * indicating that the details of this exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - IllegalArgumentExceptionThrown 
 * Date: 10/30/2022
 */
public class IllegalArgumentExceptionThrown
{
    public static void main(String[] args)
    {
        Person person = new Person();
        try 
        {
            person.setAge(-1); // this will throw the IllegalArgumentException
        }
        finally
        {
            System.out.println("This program can compile and the code in 'finally' will run anyway.");            
        }  
    }
}

// Create a class named Person which has the age attribute
class Person 
{
    int age;  // initialized age 

    // the setAge method, set age
    // Age can only be greater than zero
    public void setAge(int age) throws IllegalArgumentException //indicating this method will throw an IllegalArgumentException
    {
        if (age <= 0)  // if age <= 0, throw the IllegalArgumentException
        {
            throw new IllegalArgumentException("Age must be greater than zero \n" +
            " We are throwing an IllegalArgumentException gracefully.The error will occur " +
            "when an illegal or inappropriate argument is passed to " +
            " the method. For example, passing extra variables or passing integer value " +
            " when a String is needed, or the entered integer is out of required range. \n" );
        } else  // esle, set age
        {
            this.age = age;
        }
    }
    // the getAge method, return age
    public int getAge()
    {
        return age;
    }
}

