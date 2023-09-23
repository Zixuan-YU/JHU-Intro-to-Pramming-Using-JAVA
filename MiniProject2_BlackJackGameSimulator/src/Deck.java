/** The Deck Class: The Deck is consists of an ArrayList of Card Class.
 * It has shuffle() and draw() methods. 
 * @author Zixuan Yu
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{

    private final ArrayList<Card> cards;

    public Deck() 
    {
        cards = new ArrayList<Card>();
        // populate deck with cards
        for (Suit suit : Suit.values()) 
        {
            for (Face face : Face.values()) 
            {
                cards.add(new Card(face, suit));
            }
        }
    }

    /**
     * shuffle the cards on Deck
     */
    public void shuffle() 
    {
        Collections.shuffle(cards);
    }

    /**
     * draw a card from Deck
     * @return
     */
    public Card draw() 
    {
        return cards.remove(0);
    }

}