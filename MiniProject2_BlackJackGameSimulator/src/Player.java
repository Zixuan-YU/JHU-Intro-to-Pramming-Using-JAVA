/**
 * The Player class will similatue a player. It has two subtype: UserPlayer and Dealer. 
 * The two players will have a hand of cards each round, named userHand, dealerHand, respectively. 
 * @author: Zixuan Yu
 */


// Create an abstract class Player
public abstract class Player 
{
}


class UserPlayer extends Player
{
    UserHand userHand = new UserHand();
    int budegt;
    int bid;

    /**
     * set method of userHand
     * @param userHand
     */
    public void setUserHand( UserHand userHand)
    {
        this.userHand = userHand;
    }

    /**
     * set method of budegt
     * @param budegt
     */
    public void setBudegt( int budegt)
    {
        this.budegt = budegt;
    }

    /**
     * set method of bid
     * @param bid
     */
    public void setBid( int bid)
    {
        this.bid = bid;
    }

    /**
     * get method for userHand
     * @return userHand, cards that the userPlayer currently hold 
     */
    public UserHand getUserHand()
    {
        return userHand;
    }

    /**
     * get method for userhand
     * @return budegt, the money the userPlayer has
     */
    public int getBudegt( )
    {
        return budegt;
    }

    /**
     * get method for bid
     * @return bid, the bid of this round
     */
    public int getBid( )
    {
        return bid;
    }

    /**
     * it the user lose, he will lose his bid of this round, 
     * minus the bid from his budget
     */
    public void loseBid()
    {
        budegt = budegt - bid;
    }

    /**
     * it the user win, he will win his bid of this round,
     * add the bid to his budget
     */
    public void winBid()
    {
        budegt = budegt + bid;
    }

    /**
     * check if the user has lost all his budget
     * @return boolean value, true if the user has lost all his budget, false if budget > 0
     */
    public boolean noBudget()
    {
        if (budegt <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
}


class Dealer extends Player
{
    DealerHand dealerHand = new DealerHand();

    /**
     * set method for dealerHand
     * @param dealerHand
     */
    public void setDealerHand( DealerHand dealerHand)
    {
        this.dealerHand = dealerHand;
    }

    /**
     * get method for dealerHand
     * @return
     */
    public DealerHand getDealerHand()
    {
        return dealerHand;
    }
}
