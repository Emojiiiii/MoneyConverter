// File: UseDinnerParty.java
import java.util.Scanner;

public class UseDinnerParty {
    public static void main(String[] args) {
        int guests, choice;
        Scanner keyboard = new Scanner(System.in);

        // For the regular party
        Party aParty = new Party();
        System.out.print("Enter number of guests for the party >> ");
        guests = keyboard.nextInt();
        aParty.setGuests(guests);
        System.out.println("The party has " + aParty.getGuests() + " guests");
        aParty.displayInvitation();

        // For the dinner party
        DinnerParty aDinnerParty = new DinnerParty();
        System.out.print("\nEnter number of guests for the dinner party >> ");
        guests = keyboard.nextInt();
        aDinnerParty.setGuests(guests); // Inherits method from Party

        System.out.print("Enter the menu option -- 1 for chicken or 2 for Vegi >> ");
        choice = keyboard.nextInt();
        aDinnerParty.setDinnerChoice(choice); // Specific to DinnerParty

        System.out.println("The dinner party has " + aDinnerParty.getGuests() + " guests");
        System.out.println("Menu option " + aDinnerParty.getDinnerChoice() + " will be served");
        aDinnerParty.displayInvitation(); // Inherits method from Party
        
        keyboard.close(); // Close the scanner to prevent resource leak
    }
}
