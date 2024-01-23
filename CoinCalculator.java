import java.util.Scanner;

public class CoinCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount in dollars (e.g., 4.55): $");
        
        double amount = scanner.nextDouble();
        scanner.close();

        calculateCoins(amount);
    }

    private static void calculateCoins(double amount) {
        int cents = (int) (amount * 100);
        int quarters = cents / 25;
        int dimes = (cents % 25) / 10;
        int nickels = ((cents % 25) % 10) / 5;

        System.out.println("\nCoin breakdown for $" + amount + ":");
        System.out.println(quarters + " quarters");
        System.out.println(dimes + " dimes");
        System.out.println(nickels + " nickels");
    }
}
