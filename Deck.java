package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Deck class representing a deck of playing cards
class Deck {
    // List to store the cards in the deck
    private List<Card> cards;

    // Constructor to initialize a new deck and populate it with cards
    public Deck() {
        cards = new ArrayList<>(); // Creating a new ArrayList to store cards
        initializeDeck(); // Call method to populate the deck with cards
    }

    // Method to initialize the deck with standard playing cards
    private void initializeDeck() {
        // Loop through possible card values (from 2 to Ace, represented as 14)
        for (int value = 2; value <= 14; value++) {
            // Loop through each suit in standard playing cards
            for (String suit : new String[] { "Hearts", "Diamonds", "Clubs", "Spades" }) {
                // Get the name of the card based on its value and suit
                String cardName = getCardName(value, suit);
                // Create a new Card object with the current value and suit, and add it to the deck
                cards.add(new Card(value, cardName));
            }
        }
    }

    // Method to construct the name of a card based on its value and suit
    private String getCardName(int value, String suit) {
        // Switch statement to determine the name of the card based on its value
        switch (value) {
            case 11:
                return "Jack of " + suit;
            case 12:
                return "Queen of " + suit;
            case 13:
                return "King of " + suit;
            case 14:
                return "Ace of " + suit;
            default:
                return value + " of " + suit;
        }
    }

    // Method to shuffle the cards in the deck
    public void shuffle() {
        Collections.shuffle(cards); // Using Collections.shuffle() to shuffle the cards
    }

    // Method to draw a card from the deck
    public Card draw() {
        if (!cards.isEmpty()) { // Check if the deck is not empty
            return cards.remove(0); // Remove and return the top card from the deck
        } else {
            System.out.println("Deck is empty. Cannot draw.");
            return null; // Return null if the deck is empty
        }
    }

    // Method to check if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty(); // Return true if the deck is empty, otherwise false
    }
}
