public class Person {
    // Private fields for the first and last name of the person
    private String firstName;
    private String lastName;

    // Constructor that initializes the first and last name fields
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter method for the first name
    public String getFirstName() {
        return firstName;
    }

    // Getter method for the last name
    public String getLastName() {
        return lastName;
    }
}
