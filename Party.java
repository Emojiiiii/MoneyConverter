// File: Party.java

public class Party {
    private int guests; // Number of guests expected at the party

    // Method to set the number of guests
    public void setGuests(int numGuests) {
        guests = numGuests;
    }

    // Method to get the number of guests
    public int getGuests() {
        return guests;
    }

    // Method to display an invitation
    public void displayInvitation() {
        System.out.println("Please come to my party!");
    }
}
