
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */
    public War()
    {
        // Initializations here...
        Deck deckClass = new Deck();
        deckClass.initializeNewDeck();
        deckClass.shuffle();
        // make array w players' deck
        Deck[] abc = new Deck[2];
        abc = deckClass.dealDeck();
        // give decks to each player
        Deck player1sDeck = abc[0];
        Deck player2sDeck = abc[1];
        
        // ...then run the event loop
        this.runEventLoop();
    }
    
    
    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {

    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
