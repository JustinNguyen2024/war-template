
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    private Deck pile = new Deck();
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
        // game stops after 300 plays
        int playNumber = 0;
        while (playNumber <= 300) {
             if (playNumber == 300) {
                turnsLimit();
            }
            playNumber++;
        }
        
        
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
    
    private void whoPlayedWhat() {
        //System.out.println("P1: " + pile.getFace(pile.getDeckSize()-2)); // compile errors both
        //System.out.println("P2: " + pile.getFace(pile.getDeckSize()-1));
    }
    
    private void turnsLimit() {
        System.out.println("Game over. 300 plays have passsed.");
        // check who has more cards when 300 plays have passed; called in event loop
        if (p1Deck.getDeckSize() > p2Deck.getDeckSize()){
            System.out.println("P1 has more cards. P1 wins");
        } else if (p2Deck.getDeckSize() > p1Deck.getDeckSize()) {
            System.out.println("P2 has more cards. P2 wins");
        } else {
            System.out.println("Tie. Both players have the same amount of cards");
        }
    }
    
    private void placeCard() {
        pile.addCardToDeck(p1Deck.dealCardFromDeck());
        pile.addCardToDeck(p2Deck.dealCardFromDeck());
    }
    
    private void largerValueInPile() {
        //who has larger card value
        //start with P1
        Card p1Card = pile.getCardFromIndex(pile.getDeckSize()-2);
        Card p2Card = pile.getCardFromIndex(pile.getDeckSize()-1);
        if (p1Card.getRank() > p2Card.getRank()) {
            System.out.println("P1 has greater card");
            p1Deck.addCardToDeck(pile.dealCardFromDeck());
        } // check P2
        else if ((p2Card.getRank() > p1Card.getRank())) {
            System.out.println("P2 has greater card");
            p2Deck.addCardToDeck(pile.dealCardFromDeck());
        } else {
            warSituation();
        }
    }
    
    private void warSituation() {
        System.out.println("War!");
        //both players deal 2 cards
        for (int go = 0; go < 2; go++) {
            checkIfPlayersHaveCards();
            placeCard();
        }
        whoPlayedWhat();
        //largerValueInPile();
    }
    
    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }
}
