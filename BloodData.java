public class BloodData {
    // Enum for BloodType, quite straightforward
    public enum BloodType {
        O, A, B, AB; // The four basic blood types
    }

    // Enum for RhFactor, with a twist: storing the symbol as a string
    public enum RhFactor {
        POSITIVE("+"), NEGATIVE("-");
        
        private final String symbol; // Symbol for the Rh factor, either "+" or "-"
        
        // Constructor for RhFactor, tying each enum to its symbol
        RhFactor(String symbol) {
            this.symbol = symbol;
        }
        
        // Custom toString method to return the symbol
        @Override
        public String toString() {
            return this.symbol;
        }
    }
    
    private BloodType bloodType; // Holds the blood type
    private RhFactor rhFactor; // Holds the Rh factor
    
    // Default constructor setting the default blood type and Rh factor
    public BloodData() {
        this(BloodType.O, RhFactor.POSITIVE);
    }
    
    // Overloaded constructor for custom blood type and Rh factor
    public BloodData(BloodType bloodType, RhFactor rhFactor) {
        this.bloodType = bloodType;
        this.rhFactor = rhFactor;
    }
    
    // Setter for blood type
    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
    
    // Setter for Rh factor
    public void setRhFactor(RhFactor rhFactor) {
        this.rhFactor = rhFactor;
    }
    
    // Getter for blood type
    public BloodType getBloodType() {
        return bloodType;
    }
    
    // Getter for Rh factor
    public RhFactor getRhFactor() {
        return rhFactor;
    }
    
    // A somewhat unnecessary method to describe the blood data
    public String describe() {
        return "Blood Type: " + bloodType + ", Rh Factor: " + rhFactor;
    }
}
