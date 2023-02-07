/* 
 * This program will catches the ClassCastException and display an error message 
 * indicating that the details of this exception
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 9: Exceptions - ClassCastException 
 * Date: 10/31/2022
 */
public class ClassCastExceptionCatch
{
    public static void main( String [] args )
    {   
        Person aPerson = new Person();
        try
        {
            // attemping to casting a Person object to its subclass Boy of which it is not an instance
            Boy aBoy = (Boy)aPerson;
        } catch ( ClassCastException classCastException)
        {
            System.out.println(classCastException);
            System.out.println("This code block will handle the classCastException" +
                    " error gracefully. This error will occur when the program has" +
                    " attempted to cast an object to a subclass of which it is not an instance. \n" +
                    " The code after this code block will still run. ");
        }
    
    } // end main

} // end ClassCastExceptionCatch

// Create a class named person which has the age attribute
class Person 
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

// Create the Boy subclass
class Boy extends Person
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