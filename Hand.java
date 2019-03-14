import java.util.ArrayList;
/**
 * Represents an hand of cards.
 *
 * @author (Dan Sedano)
 * @version (10/18/18)
 */
public class Hand
{
    private ArrayList<Card>cards;

    /**
     * Creates an ArrayList of empty hands.
     */
    public Hand()
    {
        // Creates an empty hand
        cards = new ArrayList<>();
    }
    /**
     * Adds a card to the end of a hand.
     */
    public void addCard(Card c)
    {
        cards.add(c);
    }
    /**
     * @return Returns the cards to toString()
     */
    public String toString()
    {
        return cards.toString();
    }
}
