/** Course: [605.201.81] Introduction to Programming Using Java
 * Mini Project 2: Blackjack Game Simulator
 * This program will simulate the BlackJack game
 * There will be a dealer and a userPlayer. The two player will try to get
 * as close as they could to 21 points with exceeding 21 points. Both users are dealt with
 * two cards, and they would choose to hit (draw one new cards) untial they choose to stay 
 * with the current hand of cards or they win with 21 points, or they blast (exceed 21). 
 * The user will input an starting budget at the beggining of this program and 
 * the user will be asked to enter a bid for each round. 
 * The user will lose or win bid (or remains the same when there's a draw) through 
 * playing the BlackJack Game. The game will continue until the userPlayer choose to quit
 * or the user had lose all the money (budget). 
 * NOTE: please put all the source codes in a single file and type "javac *.java" in the 
 * command to copile it.
 * @author Zixuan Yu
 * @version 1.0
 * @since 10/26/2022
 */

import java.util.*;

public class BlackJackGameSimulator
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Initiate new scanner for user inputs
        // Deck deck = new Deck(); //initialize deck
        UserPlayer userPlayer = new UserPlayer();
        Dealer dealer = new Dealer();
        boolean continuePlay = true;
        boolean endRound = false;
        String inputText;

        // Ask for budget
        System.out.println ("Enter your total budegt for the game!");
        userPlayer.setBudegt(input.nextInt()); //Get the total budet
        input.nextLine();   // flush the scanner of \n
        
        while( (continuePlay) && (!userPlayer.noBudget()))
        {   
            // Start of the game
            System.out.println("");
            System.out.println("------------ BlackJack Game begins ------------");
            System.out.println("Your have $" + userPlayer.getBudegt() + ".\n");

            userPlayer.setUserHand(new UserHand()); //initialize user's Hand
            dealer.setDealerHand(new DealerHand()); //initialize dealer's Hand
            Deck deck = new Deck(); //initialize new deck
            deck.shuffle(); // shuffle the deck
             
            System.out.println ("Enter your bid for this time! ");
            userPlayer.setBid(input.nextInt()); //Get the bid
            input.nextLine();   // flush the scanner of \n

            if (userPlayer.getBid() > userPlayer.getBudegt()) 
            // bid can't be greater than the amount of money the user have 
            {
                userPlayer.setBid(userPlayer.getBudegt());
                System.out.println("The bid can't be greater than the money you have. " +
                    "I have entered the money you have as the bid");
            }

            System.out.println("Your bid is: $" + userPlayer.getBid() + ".\n");

            // deal two cards to the user
            userPlayer.userHand.addCard(deck.draw());
            userPlayer.userHand.addCard(deck.draw());

            System.out.println(userPlayer.getUserHand().toString(true)); // display user's hand

            // check if the user got a blackjack (21 points)
            if (userPlayer.userHand.winAt21())
            {
                System.out.println("You win with a BLACKJACK (21 points)! ");
                endRound = true;
                userPlayer.winBid();
            }
             
            else
            {
                // deal two cards to the dealer 
                dealer.dealerHand.addCard(deck.draw());
                dealer.dealerHand.addCard(deck.draw());
                System.out.println(dealer.dealerHand.toString(false)); // display user's hand, hiding the first card
            
                // user begins play
                // The loop asking whether the user want to draw card
                do
                {
                    System.out.println("Would you like to hit? Enter 'hit' to hit, or enter 'stay' to stay");
                 
                    do
                    {
                        inputText = input.nextLine();
                    } while (!inputText.equalsIgnoreCase("Hit") && !inputText.equalsIgnoreCase("Stay"));
                    // if the user choose to hit
                    if (inputText.equalsIgnoreCase("Hit"))
                    {
                        System.out.println("You choose to hit!");
                        userPlayer.userHand.addCard(deck.draw());
                        System.out.println(userPlayer.userHand.toString(true));

                        if (userPlayer.userHand.winAt21())
                        {
                            System.out.println("You win with 21 points! ");
                            userPlayer.winBid();
                            endRound = true;
                        }
                        else if (userPlayer.userHand.exceed21())
                        {
                            System.out.println("You went over 21! You lose, dealer wins!");
                            userPlayer.loseBid();
                            endRound = true;
                        }
                        else
                        {
                            endRound = false;
                        }
                    }

                    // if the user choose to stay
                    else if (inputText.equalsIgnoreCase("Stay"))
                    {
                        System.out.println("You choose to stay!");
                        System.out.println(userPlayer.userHand.toString(true));
                        endRound = false;
                    }    
                } while ((!endRound) && (inputText.equalsIgnoreCase("Hit")));
            }
            
            // check if the game has end
            while(!endRound) 
            {
                // dealer begins play
                System.out.println("-------------------------");
                System.out.println("Dealer's turn: ");
                System.out.println(dealer.dealerHand.toString(false));

                // if the dealer get 21 the game immediately end
                if (dealer.dealerHand.winAt21())
                {
                    System.out.println("The dealer win with a BLACKJACK (21 points)! ");
                    userPlayer.loseBid();
                    endRound = true;
                    System.out.println(dealer.dealerHand.toString(true));
                    break;
                }
            
            
                while (dealer.dealerHand.shouldHit())
                {
                    System.out.println("Dealer hit!");
                    dealer.dealerHand.addCard(deck.draw());
                }

                if (dealer.dealerHand.winAt21())
                {
                    System.out.println(dealer.dealerHand.toString(true));
                    System.out.println("Dealer wins");
                    userPlayer.loseBid();
                    endRound = true;
                }
                else if (dealer.dealerHand.exceed21())
                {
                    System.out.println(dealer.dealerHand.toString(true));
                    System.out.println("Dealer went over");
                    System.out.println("You win!");  
                    userPlayer.winBid();
                    endRound = true;                  
                }

                while (!endRound)
                {
                    System.out.println("The dealer choose to stay. ");
                    System.out.println();
                    System.out.println(userPlayer.userHand.toString(true));
                    System.out.println(dealer.dealerHand.toString(true));
                    
                    //comparePlayers();
                     
                    // if neither the user / dealer went over or get 21 points, we would compare
                    if (userPlayer.userHand.getcardSum() > dealer.dealerHand.getcardSum())
                    {
                        System.out.println("You win!");
                        userPlayer.winBid();
                    }
    
                    else if (userPlayer.userHand.getcardSum() < dealer.dealerHand.getcardSum())
                    {
                        System.out.println("The dealer wins!");
                        userPlayer.loseBid();                   
                    }
                    else
                    {
                        System.out.println("It is a draw!");                       
                    }
                    
                    endRound = true;
                }

            }
            
            System.out.println( "Your now have $" + userPlayer.getBudegt() );
            
            if (userPlayer.noBudget())
            {
                System.out.println("You've lost all your money!");
                break;
            }

            System.out.println("Do you want to play again? Enter 'yes' to play again, 'no' to quit");
            String continuePlayStr = input.nextLine(); //User input for continue playing or not
            if (continuePlayStr.equalsIgnoreCase("yes")) 
            {
                continuePlay = true;
            }
            else if (continuePlayStr.equalsIgnoreCase("no"))
            {
                continuePlay = false;
                System.out.println("You choose to quit. ");
            } 
            else
            {
                System.out.println("Please only enter yes to play again, no to quit");
            }

        }
        input.close(); //close the input
    }

}

