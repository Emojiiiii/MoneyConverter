import java.util.Scanner;

public class TestPatient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Initialize default patient using the no-argument constructor
        Patient defaultPatient = new Patient();
        System.out.println("Default Patient: " + defaultPatient.describePatient());
        
        // Collect patient ID and age from user
        System.out.println("Enter patient ID for the new patient:");
        int id = input.nextInt();
        System.out.println("Enter patient age:");
        int age = input.nextInt();
        
        // For simplicity, skipping blood data input for the second patient and using defaults
        BloodData patientBloodData = new BloodData(); // Uses default constructor values
        Patient userDefinedPatient = new Patient(id, age, patientBloodData);
        System.out.println("User Defined Patient: " + userDefinedPatient.describePatient());
        
        // For the third patient, let's mix things up: prompt for patient data but use default BloodData
        System.out.println("For another patient, let's just use default BloodData.");
        System.out.println("Enter another patient ID:");
        int anotherId = input.nextInt();
        System.out.println("Enter another patient age:");
        int anotherAge = input.nextInt();
        
        // Creating the third patient with user-defined ID and age but default BloodData
        Patient mixedPatient = new Patient(anotherId, anotherAge, new BloodData()); // Default BloodData used
        System.out.println("Mixed Patient (User-defined ID/Age, Default BloodData): " + mixedPatient.describePatient());
        
        // Closing the scanner object
        input.close();
    }
}

