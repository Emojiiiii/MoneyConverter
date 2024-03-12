// Represents a grocery item with a name and a price.
public class Item {
    private String name; // Name of the item
    private double price; // Price per unit of the item
    private int bulkQuantity; // Quantity needed for bulk discount
    private double bulkPrice; // Bulk price for the item

    // Constructor for items without bulk discounts
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        // By default, no bulk discount is applied
        this.bulkQuantity = 0;
        this.bulkPrice = 0.0;
    }

    // Constructor for items with bulk discounts
    public Item(String name, double price, int bulkQuantity, double bulkPrice) {
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
    }

    // Getter for the item name
    public String getName() {
        return name;
    }

    // Getter for the item price per unit
    public double getPrice() {
        return price;
    }

    // Calculates the price for a specified quantity, applying bulk discount if applicable
    public double getPriceForQuantity(int quantity) {
        if (bulkQuantity > 0 && quantity >= bulkQuantity) {
            // Calculate price for bulk quantities and remaining units
            int bulkSets = quantity / bulkQuantity;
            int remainingUnits = quantity % bulkQuantity;
            return bulkSets * bulkPrice + remainingUnits * price;
        }
        // Price without bulk discount
        return quantity * price;
    }
}