/** The Card Class: Each Card object has the face attribute (value used when calculating Hand sum), 
 * the suit attribute, and the corresponding get and set methods.  
 * @author Zixuan Yu
 */
public class Card 
{
    private final Face face; //initialize face
    private final Suit suit; //initialize suit

    /**
     * Class constructor. It will construct the Card class using face (a Face object) and suit (a Suit object)
     * @param face
     * @param suit
     */
    public Card(Face face, Suit suit) 
    {
        this.face = face;
        this.suit = suit;
    }

    /**
     * get method for face
     * @return the face attribute (value of the card) of the Card object
     */
    public Face getFace() 
    {
        return face;
    }

    /**
     * get method for suit
     * @return the suit attribute of the Card object
     */
    public Suit getSuit() 
    {
        return suit;
    }

    /**
     * toString method
     * @return the card's suit and its face (value), e.g. "DIAMONDS Three".
     */
    public String toString() 
    {
        return suit + " " + face ;
    }

}

