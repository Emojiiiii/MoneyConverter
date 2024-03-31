public class Patient {
    private int id; // Patient ID
    private int age; // Patient age
    private BloodData bloodData; // Patient's BloodData
    
    // Default constructor with preset values
    public Patient() {
        this(0, 0, new BloodData());
    }
    
    // Overloaded constructor for custom patient details
    public Patient(int id, int age, BloodData bloodData) {
        this.id = id;
        this.age = age;
        this.bloodData = bloodData;
    }
    
    // Getter for ID
    public int getId() {
        return id;
    }
    
    // Getter for age
    public int getAge() {
        return age;
    }
    
    // Getter for BloodData
    public BloodData getBloodData() {
        return bloodData;
    }
    
    // Method to output patient details in a string
    public String describePatient() {
        return "Patient ID: " + id + ", Age: " + age + ", Blood Data: [" + bloodData.describe() + "]";
    }
}

