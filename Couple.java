public class Couple {
    // Private fields for the bride and groom, each represented as a Person object
    private Person bride;
    private Person groom;

    // Constructor that initializes the bride and groom fields
    public Couple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }

    // Getter method for the bride
    public Person getBride() {
        return bride;
    }

    // Getter method for the groom
    public Person getGroom() {
        return groom;
    }
}
