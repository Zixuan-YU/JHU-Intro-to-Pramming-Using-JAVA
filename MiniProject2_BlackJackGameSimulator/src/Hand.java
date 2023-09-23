/** The Hand Class: mimic the cards in player's hand.
 * UserHand and DealerHand are subclasses of Hand which include an Arraylist of Card objects. 
 * Hand and its subclasses have the toString method which has a Boolean value (displayAll) as argument: 
 * when displayAll equals true, the cards in Hand and the sum will be displayed; when displayAll is set 
 * to false in DealerHand, only the first card will be displayed, otherwise, the program will display a 
 * message informing that this is only for the DealerHand subclass. Hand’s other methods include 
 * getcardSum() (return the sum of cards, Ace could be either 1 or 11), countAce() (returns the number of Ace in Hand), 
 * exceed21() (returns a Boolean value, true if sum greater than 21), winAt21 (returns a Boolean value, true if sum equals 21). 
 * @author Zixuan Yu
 */

import java.util.ArrayList;

public class Hand 
{
    public ArrayList<Card> cards;
    private boolean containACE;
    public Hand() 
    {
        this.cards = new ArrayList<>();
    }

    /**
     * contructor of Hand
     * @param cards
     */
    public Hand(ArrayList<Card> cards)
    {
        this.cards = cards;
    }

    /**
     * get method of Hand
     * @return a ArrayList of Cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * addCard method, add a card to Hand
     * @param card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * checke if the hand contain Ace
     * @return boolean value, true if contain ACE
     */

    public boolean containAce()
    {

        for (Card card : cards)
        {
            if (card.getFace() == Face.ACE)
            {
                containACE = true;
            }
        }
        return containACE; 
    }

    /**
     * count how many Ace in Hand
     * @return int, how many Ace in Hand
     */
    public int countAce()
    {
        int count = 0;

        for (Card card : cards)
        {
            if (card.getFace() == Face.ACE)
            {
                count++;
            }
        }
        return count; 
    }

    /**
     * get the sum of the cards in hand
     * @return sum of the cards in hand
     */
    public int getcardSum()
    {
        int cardSum = 0;
        for (Card card : cards)
        {
            cardSum += card.getFace().getValue();
        }
        
        int minusAceCount = 0;
        while(( cardSum > 21) && containAce() && countAce() != minusAceCount)
        {
            cardSum = cardSum - 10;
            minusAceCount ++;
        }

        return cardSum;
    }

    /**
     * check if card sum has exceed 21
     * @return true if card sum > 21, false if <= 21
     */
    public boolean exceed21() {
        return getcardSum() > 21;
    }

    public boolean winAt21() {
        return getcardSum() == 21;
    }

    /**
     * Display card in hand and sum
     * @param displayAll true to display all card and value, false to display a message indicating this only work for DealerHand
     * @return card in hand and sum
     */
    // @Override
    public String toString( boolean displayAll )
    {
        if (displayAll)
        {
        // return the cards in hand
            String cardsString = "";
            for( int i = 0; i < cards.size(); i++)
            {
                cardsString = cardsString + cards.get(i) + " | ";
            }
            cardsString = cardsString + "Sum: " + getcardSum();
            return cardsString;
        }
        else
        {
            return ("The displayAll = false will only work in the DealerHand subclass");
        }

    }
    
}


class UserHand extends Hand
{   
    /**
     * Display card in hand and sum
     * @param displayAll true to display all card and value, false to display a message indicating this only work for DealerHand
     * @return card in hand and sum
     */
    @Override 
    public String toString( boolean displayAll )
    {
        if (displayAll)
        {
            // return the cards in hand
            String cardsString = "User hand: " + super.toString(true) ;
            return cardsString + "\n";  
        }
        else
        {
            return ("The displayAll = false will only work in the DealerHand subclass");
        }
        
    }
}

class DealerHand extends Hand
{
    /**
     * Display card in hand and sum
     * @param displayAll true to display all card and value, false to display only the first card
     * @return card in hand and sum
     */
    @Override 
    public String toString( boolean displayAll )
    {   
        String cardsString = "Dealer hand: ";
        // display all the cards in hand
        if (displayAll)
        {
            cardsString = cardsString + super.toString(true);
        }
        else // if not display All, then hide the first card
        {
            for( int i = 0; i < cards.size(); i++)
            {
                if (i == 1)
                {
                    cardsString = cardsString + " ? " + " | ";
                }
                else
                {
                    cardsString = cardsString + cards.get(i) + " | "; 
                }
            }
        }
        return cardsString + "\n";
    }

    /**
     * check if the dealer should hit, hit when sum < 17
     * @return true is sum < 17, false otherwise
     */
    public boolean shouldHit()
    {   
        return getcardSum() < 17;
    }
}

