/** The Suit Class: Enumerate through each face of the card and its corresponding values
 * @author Zixuan Yu
 */
public enum Face 
{
    ACE(11), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), 
    Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);

    private int value;

    Face(int value) 
    {
        this.value = value;
    }
    
    public int getValue() 
    {
        return value;
    }

}