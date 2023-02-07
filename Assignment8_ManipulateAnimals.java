/* 
 * This program will create two Animal class objects, and two Vehicle class objects
 * both the Animals and the Vehicles has four interfaces: Drawable, Rotatable, Resizable and Sounds.
 * The four interfaces has the drawObject(), rotateObject(), resizeObject() and playSound(), respectively.
 * This program will rotate through the list of the four objects and draw it, rotate it, resize it, and play sound
 * for each objects. 
 * Author: Zixuan Yu
 * Course: [605.201.81] Introduction to Programming Using Java
 * Assignment 8：  ManipulateAnimals
 * Date: 10/23/2022
 */
public class ManipulateAnimals
{
    public static void main( String [] args )
    {   
        // Create the list containing two Animal class objects, and two Vehicle class objects
        Item [] itemCollection = { new Animal(), new Animal(), new Vehicle(), new Vehicle() };
        // rotates through each item/object in the list
        for ( int i = 0; i < itemCollection.length; i++)
        {
            itemCollection[i].drawObject(); //Invoke the Polymorpheric drawObject() method 
            itemCollection[i].rotateObject(); //Invoke the Polymorpheric rotateObject() method 
            itemCollection[i].resizeObject(); //Invoke the Polymorpheric resizeObject() method 
            itemCollection[i].playSound(); //Invoke the Polymorpheric playSound() method 
            System.out.println(""); // Print a blank line between each Item
        }  
    }
}

// Initiate the abstract class Item which implents the rawable, Rotatable, Resizable, Sounds interface
abstract class Item implements Drawable, Rotatable, Resizable, Sounds
{
}

// functional interface Drawable only has the drawObject() method
interface Drawable
{
    void drawObject();
}

// functional interface Rotatable only has the rotateObject() method
interface Rotatable
{
    void rotateObject();
}

// functional interface Resizable only has the resizeObject() method
interface Resizable
{
    void resizeObject();
}

// functional interface Sounds only has the playSound() method
interface Sounds
{
    void playSound();
}

// The Animal class extends the Item abstract class
class Animal extends Item
{
    // initializing class variables privately
    private String name;

    // constructor with all parameters
    Animal(String newName)
    {
        name = newName;
    }

    // constructor without parameters
    Animal()
    {
        name = "<unknown>";
    }

    /*
     * The method setName will set the name variable
    * Pre-conditions: name is initialized
    * Post-conditions: name is a Sring
    */
    // Assigning variables
    public void setName(String newName)
    {
        name = newName;
    }

    /*
     * The method setAge will set the age variable
     * Pre-conditions: age is initialized
    * Post-conditions: age is Integer
     */

    // get method: for returning variables
    public String getName()
    {   // return name
        return name;
    }

    // override the drawObject method
    public void drawObject()
    {
        System.out.println("Drawing an Animal");
    }

    // override the rotateObject method
    public void rotateObject()
    {
        System.out.println("Rotating an Animal");
    }

    // override the resizeObject method
    public void resizeObject()
    {
        System.out.println("Resizing an Animal");
    }

    // override the playSound method
    public void playSound()
    {
        System.out.println("Animal sound");
    }
}

// The vehicle class extends the Item abstract class
class Vehicle extends Item
{
    // initializing class variables privately
    private String name;
    private int age;

    // constructor with all parameters
    Vehicle(String newName, int newAge)
    {
        name = newName;
        age = newAge;
    }

    // constructor without parameters
    Vehicle()
    {
        name = "<unknown>";
        age = -1; //let -1 be the missing value of age
    }
    /*
     * The method setName will set the name variable
    * Pre-conditions: name is initialized
    * Post-conditions: name is a Sring
    */
    // Assigning variables
    public void setName(String newName)
    {
        name = newName;
    }

    /*
     * The method setAge will set the age variable
     * Pre-conditions: age is initialized
    * Post-conditions: age is Integer
     */
    public void setAge(int newAge)
    {
        age = newAge;
    }

    // get method: for returning variables

    public String getName()
    {   // return name
        return name;
    }

    public int getAge()
    {   // return age
        return age;
    }

    // override the drawObject method
    public void drawObject()
    {
        System.out.println("Drawing a Vehicle");
    }
    
    // override the rotateObject method
    public void rotateObject()
    {
        System.out.println("Rotating a Vehicle");
    }

    // override the resizeObject method
    public void resizeObject()
    {
        System.out.println("Resizing a Vehicle");
    }

    // override the playSound method
    public void playSound()
    {
        System.out.println("Vehicle sound");
    }

}
        
