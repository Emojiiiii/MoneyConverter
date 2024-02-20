import java.time.LocalDate;
import java.util.Scanner;

public class TestWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the bride's first name:");
        String brideFirstName = scanner.nextLine();
        System.out.println("Enter the bride's last name:");
        String brideLastName = scanner.nextLine();
        Person bride = new Person(brideFirstName, brideLastName);

        System.out.println("Enter the groom's first name:");
        String groomFirstName = scanner.nextLine();
        System.out.println("Enter the groom's last name:");
        String groomLastName = scanner.nextLine();
        Person groom = new Person(groomFirstName, groomLastName);

        Couple couple = new Couple(bride, groom);

        System.out.println("Enter the wedding date (YYYY-MM-DD):");
        LocalDate weddingDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the location of the wedding:");
        String location = scanner.nextLine();

        Wedding wedding = new Wedding(couple, weddingDate, location);

        // Display details
        System.out.println("Wedding Details:");
        System.out.println("Bride: " + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName());
        System.out.println("Groom: " + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName());
        System.out.println("Date: " + wedding.getWeddingDate());
        System.out.println("Location: " + wedding.getLocation());

        scanner.close();
    }
}
