import java.util.Scanner;
import java.util.ArrayList;
/**
 * Controls all the classes
 *
 * @author (Dan Sedano)
 * @version (10/19/18)
 */
public class DealHands
{
    public static final int CARDS = 5;
    
    public static void main(String[] args)
    {
        //Creates an Deck object
        Deck goFish = new Deck();
        
        //Creates a scanner object
        Scanner input = new Scanner(System.in);
        
        //Prints out a brand new deck.
        System.out.println("New Deck:");
        System.out.print(goFish.toString());
        
        //Calls the shuffle method of the deck class and prints out the result.
        System.out.println("\nShuffled Deck:");
        goFish.shuffle();
        System.out.print(goFish.toString());
        
        //Asks user for amount of players
        System.out.print("\nHow many players? ");
        int amountHands = input.nextInt();
        
        //Creates an ArrayList of Hands.
        ArrayList<Hand> hands = new ArrayList<>();
        
        //Takes user input and creates as many hands as were requested by user. 
        for(int h = 0; h < amountHands; ++h)
        {
            hands.add(new Hand());
        }
        
        //adds the cards to each hand
        for(int x = 0; x < CARDS; ++x)
        {
            for(int h = 0; h < amountHands; ++h)  
            {
                //Removes a card from Deck ArrayList and returns the value of that card to the addCard method of the Hand Class
                hands.get(h).addCard(goFish.dealCard());               
            }
        }
        
        System.out.println("\n" + "The hands for all " + amountHands + " players:");
        //Prints out the hands of each player
        for(int h = 0; h < amountHands; ++h)
        {
            System.out.println(hands.get(h).toString());
        } 
        
        //Prints out the remaining cards
        System.out.println("\nCards remaining in deck:");
        System.out.print(goFish.toString());
        
        int errRank = 1;
        int errSuit = 5;
        int goodRank = 11;
        int goodSuit = 3;
        
        System.out.println("\n\nCard creation error testing:\n");
        //created 4 tests 1 of the tests should pass
        Card errTesting = new Card(errRank,goodSuit); // will print 1 error line
        Card errTesting2 = new Card(goodRank,errSuit); // will print 1 error line
        Card errTesting3 = new Card(errRank,errSuit); // will print 2 error lines
        Card errTesting4 = new Card(goodRank,goodSuit); // will not print anything
        
        System.out.println("\nCard dealing error testing:\n");
        Deck deckTest = new Deck();

        int count = 52;
        do
        {
            deckTest.dealCard();
            --count;
            //System.out.println("Cards remaining in deck: " + count);
        }while(count >= 0);
    }
}
