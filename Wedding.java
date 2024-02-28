import java.time.LocalDate;

public class Wedding {
    // Private fields for the couple, wedding date, and location of the wedding
    private Couple couple;
    private LocalDate weddingDate;
    private String location;

    // Constructor that initializes the couple, wedding date, and location fields
    public Wedding(Couple couple, LocalDate weddingDate, String location) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
    }

    // Getter method for the couple
    public Couple getCouple() {
        return couple;
    }

    // Getter method for the wedding date
    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    // Getter method for the wedding location
    public String getLocation() {
        return location;
    }
}

