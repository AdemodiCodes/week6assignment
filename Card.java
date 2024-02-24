package week6;

// Card class representing a playing card
class Card {
    // Private fields to store the value and name of the card
    private int value;
    private String name;

    // Constructor to initialize a Card object with given value and name
    public Card(int value, String name) {
        this.value = value; // Assigning the value parameter to the value field
        this.name = name; // Assigning the name parameter to the name field
    }

    // Getter method to retrieve the value of the card
    public int getValue() {
        return value; // Returning the value of the card
    }

    // Getter method to retrieve the name of the card
    public String getName() {
        return name; // Returning the name of the card
    }

    // Method to describe the card
    public void describe() {
        System.out.println(name); // Printing the name of the card
    }

}