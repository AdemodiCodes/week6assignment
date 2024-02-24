package week6;

// Main class of the application
public class App {
    // Main method
    public static void main(String[] args) {
        // Instantiate Deck and Players
        Deck deck = new Deck(); // Creating a new deck object
        Player player1 = new Player("Player 1"); // Creating player 1 object
        Player player2 = new Player("Player 2"); // Creating player 2 object

        // Shuffle the deck
        deck.shuffle(); // Shuffling the deck

        // Draw cards for each player
        for (int i = 0; i < 52; i++) { // Loop through 52 times (number of cards in the deck)
            // Check if the deck is empty before drawing cards
            if (!deck.isEmpty()) { // If the deck is not empty
                player1.draw(deck); // Player 1 draws a card from the deck
                player2.draw(deck); // Player 2 draws a card from the deck
            } else {
                System.out.println("Deck is empty. Cannot draw more cards.");
                break; // Exit the loop if the deck is empty
            }
        }

        // Flip cards and determine the winner
        for (int i = 0; i < 26; i++) { // Loop through 26 times (assuming each player has drawn 26 cards)
            // Check if either player is out of cards
            if (player1.isHandEmpty() || player2.isHandEmpty()) { // If any player is out of cards
                System.out.println("One of the players is out of cards. Game over.");
                break; // Exit the loop if any player is out of cards
            }

            Card card1 = player1.flip(); // Player 1 flips a card
            Card card2 = player2.flip(); // Player 2 flips a card

            // Print the cards flipped by each player
            System.out.println(player1.getName() + " flipped:");
            if (card1 != null && card1.getValue() != 0) {
                card1.describe();
            } else {
                System.out.println("No card flipped or placeholder card.");
            }

            System.out.println(player2.getName() + " flipped:");
            if (card2 != null && card2.getValue() != 0) {
                card2.describe();
            } else {
                System.out.println("No card flipped or placeholder card.");
            }

            // Compare the values of the flipped cards and determine the winner of the round
            if (card1.getValue() > card2.getValue()) { // If player 1's card value is greater
                player1.incrementScore(); // Player 1 receives a point
                System.out.println(player1.getName() + " receives a point!");
            } else if (card1.getValue() < card2.getValue()) { // If player 2's card value is greater
                player2.incrementScore(); // Player 2 receives a point
                System.out.println(player2.getName() + " receives a point!");
            } else { // If it's a tie
                System.out.println("It's a tie! No point awarded.");
            }

            // Print updated scores
            System.out.println("Score - " + player1.getName() + ": " + player1.getScore() + ", " + player2.getName() + ": " + player2.getScore());
        }

        // Compare final scores and determine the winner of the game
        System.out.println("\nFinal Scores:");
        System.out.println(player1.getName() + ": " + player1.getScore() + ", " + player2.getName() + ": " + player2.getScore());

        if (player1.getScore() > player2.getScore()) { // If player 1's score is greater
            System.out.println("The winner is " + player1.getName() + "!");
        } else if (player1.getScore() < player2.getScore()) { // If player 2's score is greater
            System.out.println("The winner is " + player2.getName() + "!");
        } else { // If it's a tie
            System.out.println("It's a draw!");
        }
    }
}
