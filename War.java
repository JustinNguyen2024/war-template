
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    private Deck p1Deck;
    private Deck p2Deck;
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */ 
    // setup
    public War()
    {
        // Initializations here...
        Deck deckClass = new Deck();
        deckClass.initializeNewDeck();
        deckClass.shuffle();
        // make empty array w players' deck
        Deck[] deck = new Deck[2];
        // fill up array + split into temporary halves
        deck = deckClass.dealDeck();
        // take halves and give to each player
        p1Deck = deck[0];
        p2Deck = deck[1];
        
        // ...then run the event loop
        this.runEventLoop();
    }
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    // gameplay
    public void runEventLoop() {
        
    }
    
    private void checkIfPlayersHaveCards() {
        if (p1Deck.getDeckSize() == 0) {
            if (p2Deck.getDeckSize() == 0) {
                System.out.println("tie");
            } else {
                System.out.println("P2 won");
            }
        } else {
            System.out.println("P1 won");
        }
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
