// File: UseParty.java
import java.util.Scanner;

public class UseParty {
    public static void main(String[] args) {
        int guests;
        Scanner keyboard = new Scanner(System.in);
        Party aParty = new Party();

        System.out.print("Enter number of guests for the party >> ");
        guests = keyboard.nextInt();
        aParty.setGuests(guests);

        System.out.println("The party has " + aParty.getGuests() + " guests");
        aParty.displayInvitation();

        keyboard.close(); // Close the scanner to prevent resource leak
    }
}
