package week6;

import java.util.ArrayList;
import java.util.List;

// Player class representing a player in the card game
class Player {
    // List to store the cards in the player's hand
    private List<Card> hand;
    // Variable to store the player's score
    private int score;
    // Variable to store the player's name
    private String name;

    // Constructor to initialize a new player with a given name
    public Player(String name) {
        this.hand = new ArrayList<>(); // Creating a new ArrayList to store cards in the player's hand
        this.score = 0; // Setting the initial score to 0
        this.name = name; // Assigning the given name to the player
    }
    
    // Method to retrieve the player's name
    public String getName() {
        return name; // Returning the player's name
    }

    // Method to describe the player's hand by printing out each card
    public void describe() {
        System.out.println(name + "'s hand:"); // Printing the player's name followed by "'s hand:"
        for (Card card : hand) { // Looping through each card in the player's hand
            card.describe(); // Calling the describe() method of each card to print its name
        }
    }
    
    // Method to check if the player's hand is empty
    public boolean isHandEmpty() {
        return hand.isEmpty(); // Returning true if the hand is empty, otherwise false
    }

    // Method for the player to flip a card from their hand
    public Card flip() {
        if (!hand.isEmpty()) { // Check if the hand is not empty
            return hand.remove(0); // Remove and return the first card from the hand
        } else {
            System.out.println(name + "'s hand is empty."); // Print a message indicating the hand is empty
            return new Card(0, "No Card"); // Return a placeholder card with value 0 and name "No Card"
        }
    }

    // Method for the player to draw a card from the deck and add it to their hand
    public void draw(Deck deck) {
        Card card = deck.draw(); // Draw a card from the deck
        hand.add(card); // Add the drawn card to the player's hand
    }

    // Method to increment the player's score
    public void incrementScore() {
        score++; // Incrementing the score by 1
    }

    // Method to retrieve the player's score
    public int getScore() {
        return score; // Returning the player's score
    }
}
