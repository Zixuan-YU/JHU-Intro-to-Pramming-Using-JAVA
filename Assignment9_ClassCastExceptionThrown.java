/* 
 * This program will throw the ClassCastException and display an error message 
 * indicating that the details of this exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - ClassCastException 
 * Date: 10/25/2022
 */
public class ClassCastExceptionThrown
{
    public static void main( String [] args ) throws ClassCastException
    {   
        Student student = new Student();

        try
        {
            // attemping to casting a Student object to its subclass MaleStudent of which it is not an instance of
            
            if (student instanceof MaleStudent)
            {
                MaleStudent mStudent = (MaleStudent)student;    
            }
            else
            {
                throw new ClassCastException("This will cause ClassCastExceptionCatch because student is not an instance of MaleStudent");
            }
        } 
        finally
        {
            System.out.println("This program can compile and the code in finally will run anyway.");            
        }

        /* catch ( ClassCastException classCastException)
        {
            System.out.println(classCastException);
            System.out.println("This code block will handle the classCastException" +
                    " error gracefully. This error will occur when the program has" +
                    " attempted to cast an object to a subclass of which it is not an instance. \n" +
                    " The code after this code block will still run. ");
        }
        */
    
    } // end main

} // end ClassCastExceptionThrown

// Create a class named Student which has the age attribute
class Student 
{
    int age; // initialized age 
    
    // set age
    public void setAge(int age) 
    {
        this.age = age;
    }
    // get age
    public int getAge() 
    {
        return age;
    }
}

// Create the MaleStudent subclass
class MaleStudent extends Student
{
    String gender;
    // set gender
    public void setGender(String gender) 
    {
        this.gender = gender;
    }
    // get gender
    public String getGender() 
    {
        return gender;
    }    
}