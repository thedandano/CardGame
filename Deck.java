import java.util.ArrayList;
import java.util.Random;
import java.util.*;
/**
 * Represents an entire deck of cards.
 *
 * @author (Dan Sedano)
 * @version (10/18/18)
 */
public class Deck
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> cards;
    
    private static final int SUITS =  4 ;
    private static final int CARDS_PER_SUIT = 13;

    /**
     * Creates an a deck of 52 cards.
     */
    public Deck()
    {
        // initialise instance variables
        cards = new ArrayList<>();
        //added to avoid error being triggered when creating cards
        int cardsInSuit = CARDS_PER_SUIT + 1;
        //nested for loop creates 52 cards
        for(int x = 0; x < SUITS; x++)
            for(int y = 2; y <= cardsInSuit; y++)
                cards.add(new Card(y,x));
    }
    /**
     * Shuffles the deck of cards.
     */
    public void shuffle()
    {
        Random shuffle = new Random();
        //creates a temporary container for cards to go into
        ArrayList<Card> temp = new ArrayList<Card>();
        
        while (cards.size() > 0)
        {
            //Randomly selects a card to remove from card ArrayList and adds it to temp ArrayList
            temp.add(cards.remove(shuffle.nextInt(cards.size())));
        }
        //Sets temp ArrayList to card ArrayList, therefore effectively shuffling cards.
        cards = temp;
        //Collections.shuffle(cards);
    }
    /**
     * Deals a card and will provide user with an error if deck is empty.
     * @return The card delt.
     */
    public Card dealCard()
    {
      Card dealCard = null;
      
      if (cards.isEmpty())
      {
          System.out.println("Deck is empty...exiting...");
          //System.err.println("Deck is empty...exiting...");
          //System.exit(3);
      }
      else
      {
          //removes card from the first position and returns it
          dealCard = cards.remove(0);
      }
      return dealCard; 
    }
    /**
     * Formats the output of the entire deck.
     * @return The format to toString().
     */
    public String toString()
    {
        String print = "";
        int row = 0;
        //uses a for_each loop to read the ArrayList and adds a new space character every CARD_PER_SUIT cards.
        for(Card card : cards)
        {
            print += card.toString() + " ";
            ++row;
            if(row % CARDS_PER_SUIT == 0)
                print += '\n';              
        }
        return print;
    }
}
