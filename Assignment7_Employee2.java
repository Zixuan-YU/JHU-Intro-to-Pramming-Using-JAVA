/* Course: [605.201.81] Introduction to Programming Using Java
 * Module7:
 * This program will model 3 employees. A salaried employee who is paid by annual salary,
 * and two hourly employee  who is paid by hourly rate adjusted by their working hours.
 * It will display basic information of the employee (Name, Address, Employment Date) and their earnings.
 * Author: Zixuan Yu
 * Date: 10/15/2022
 */
public class Employee2
{
    public static void main(String[] args )
    {    
        Employee[] employeeList; //array to hold all employees
        employeeList = new Employee[3];
        // int empID; // initialized the ID for the employees

        System.out.println();
        System.out.println("Employee Directory: ");       

        employeeList[0] = new SalariedEmployee(1,86000);
        employeeList[0].setName("Amy", "Hilton");
        employeeList[0].setAddress("300 Cathedral St", "Baltimore","MD","21201");
        employeeList[0].setDate(1, 21, 2018);

        employeeList[1] = new HourlyEmployee(2,15,38);
        employeeList[1].setName("Amy", "Hilton");
        employeeList[1].setAddress("123 Some St", "Anytown","NY","22200");
        employeeList[1].setDate(2, 15, 2019);
        
        employeeList[2] = new HourlyEmployee(3,8.25,48);
        employeeList[2].setName("Tony", "Stark");
        employeeList[2].setAddress("5250 Hollywood Blvd", "Beverly Hills","CA","90021");
        employeeList[2].setDate(3, 5, 2022);

        // Loop through each employee, printing out basic informations and earnings
        for (int i = 0; i < 3; i++)
        {
            System.out.println(employeeList[i].displayInfo());
        }
   
    }
}


class Employee
{
    // initializing class variables privately
    private int id;
    private Assign7_Name name;
    private Assign7_Address address;
    private Assign7_Date date;

    // constructor with all parameters
    Employee(int newID)
    {
        id = newID;
    }

    // Set methods: Assigning variables
    public void setID(int newID)
    {
        id = newID;
    }

    public void setName(String firstName, String lastName)
    {
        name = new Assign7_Name(firstName, lastName);
    }

    public void setAddress(String street, String city, String state, String zip)
    {
        address = new Assign7_Address(street, city, state, zip);
    }

    public void setDate(int month, int day, int year)
    {
        date = new Assign7_Date(month, day, year);
    }

    // get method: for returning variables
    public String displayInfo()
    {   // return the Employee's id, name, address and employment date
        return ("Employee Record: " +
                "\nID: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\nHire date:" + date );
    }

    public int getID()
    {   // return id
        return id;
    }

    public Assign7_Name getName()
    {   // return name
        return name;
    }

    public Assign7_Address getAddress()
    {   // return address
        return address;
    }

    public Assign7_Date getDate()
    {   // return date
        return date;
    }    
    public double earnings()
    {
        return 0; 
        // Earning calculation method and amount are specified in child classes
    }    
}


// The Assign7_Name class
class Assign7_Name
{
    // initializing class variables privately
    private String firstName;
    private String lastName;

    // constructor with all parameters
    Assign7_Name(String newFirstName, String newLastName)
    {
        firstName = newFirstName;
        lastName = newLastName;
    }

    // constructor without parameters
    Assign7_Name()
    {
        firstName = "<unknown>";
        lastName = "<unknown>";
    }

    // Assigning variables
    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }

    /* The method setLastName will set the lastName variable
    * Pre-conditions: lastName is initialized
    * Post-conditions: lastName is String
    */
    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }

    // get method: for returning variables
    public String toString()
    {   // return the name, in 'lastName, firstName' format
        return (lastName + ", " + firstName);
    }

    public String getFirstName()
    {   // return FirstName
        return firstName;
    }

    public String getLastName()
    {   // return lastName
        return lastName;
    }

}

// The Assign7_Address class
class Assign7_Address
{
    // initializing class variables privately
    private String street;
    private String city;
    private String state;
    private String zip;

    // constructor with all parameters
    Assign7_Address(String newStreet, String newCity, String newState, String newZip)
    {
        street = newStreet;
        city = newCity;
        state = newState;
        zip = newZip;
    }

    // constructor without parameters
    Assign7_Address()
    {
        street = "<unknown>";
        city = "<unknown>";
        state = "<unknown>";
        zip = "<unknown>";
    }

    // Assigning variables
    public void setStreet(String newStreet)
    {
        street = newStreet;
    }

    public void setCity(String newCity)
    {
        city = newCity;
    }

    public void setState(String newState)
    {
        state = newState;
    }
/*
 * The method setZip will set the zipcode variable
 * Pre-conditions: zip is initialized
 * Post-conditions: zip is integer
 */
    public void setZip(String newZip)
    {
        zip = newZip;
    }

    // get method: for returning variables

/*
 * The method toString will return the vales for the full address
 * Pre-conditions: street, city, sate are set to String values and Zipcod is integer
 * Post-conditions: String containing street, city, state and Zipcode is returned
 */
    public String toString()
    {   // return the name, in 'lastName, firstName' format
        return (street + ", " + city + ", " + state + " " + zip);
    }

    public String getStreet()
    {   // return street
        return street;
    }

    public String getCity()
    {   // return city
        return city;
    }

    public String getState()
    {   // return state
        return state;
    }

    public String getZip()
    {   // return zip
        return zip;
    }

}

// The Assign7_Date class
class Assign7_Date
{
    // initializing class variables privately
    private int month = 0;
    private int day = 0;
    private int year = 0;

    // constructor with all parameters
    Assign7_Date(int newMonth, int newDay, int newYear)
    {
        month = newMonth;
        day = newDay;
        year = newYear;
    }

    public void setMonth(int newMonth)
    {   // set month
        month = newMonth;
    }

    public void setDay(int newDay)
    {   // set day
        day = newDay;
    }

    public void setYear(int newYear)
    {   // set year
        year = newYear;
    }
/*
 * The method toString will return the vales for the full Hire date
 * Pre-conditions: month is 1-12, day is 1 to the last day of that month, year is 1990-2022
 * Post-conditions: String containing month / day / year is returned
 */
    public String toString()
    {   // return the date in month/day/year format
        return (month + "/" + day + "/" + year);
    }

    public int getMonth()
    {   // return month
        return month;
    }
/*
 * The method getDay will return the vales for day
 * Pre-conditions: day is integer from 1-the last day of that month
 * Post-conditions: Int day is returned
 */
    public int getDay()
    {   // return day
        return day;
    }

    public int getYear()
    {   // return year
        return year;
    }
}




class SalariedEmployee extends Employee
{
    private double annualSalary;
    // constructor
    public SalariedEmployee( int newID, double salary)
    {
        super( newID );
        annualSalary = salary;
    }
    // set salary
    //public void setAnnualSalary( double salary )
    //{
    //    annualSalary = salary;
    //}
    // return salary
    public double getAnnualSalary()
    {
        return annualSalary;
    }
    public double earnings()
    {
        return annualSalary; // earnings are annual salaries
    }
    public String displayInfo()
    {   
        return( super.displayInfo() + // invoke the displayInfo method in the parent class to display personal info
        "\nAnnual Salary: $" + earnings() + "\n"); // print earnings
    }
}


class HourlyEmployee extends Employee
{
    private double wage; // wage per hour
    private double hours; // hours worked for week
    private double earnings; // total earning for given time period

    // constructor
    public HourlyEmployee( int newID, double hourlyWage, double hoursWorked)
    {
        super( newID );
        wage = hourlyWage;
        hours = hoursWorked;
    }
    // set wage
    public void setWage( double hourlyWage )
    {
        wage = hourlyWage;
    }
    // return wage
    public double getWage()
    {
        return wage;
    }
    // set hoursWorked
    public void setHours( double hoursWorked )
    {
        hours = hoursWorked;
    }
    // return hoursWorked
    public double getHours()
    {
        return hours;
    }
    // calculate earnings; override abstract method earnings in Employee
    public double earnings()
    {
        if (hours > 40)
        {
            return (40*wage + (hours-40)*wage*1.5);
            // The hours exceed 40 hours will be paid 1.5 time the base hourly rate
        }
        else
        {
            return (hours*wage);
        }
    }
    public String displayInfo()
    {   
        return( super.displayInfo() + // invoke the displayInfo method in the parent class to display personal info
            "\nHourly Pay Rate: $" + wage + // print Hourly Pay Rate
            "\nHours Worked: " + hours + // print Hours Worked
            "\nEarnings: $" + earnings() + "\n"); // print earnings
    }

}





        
