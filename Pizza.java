public class Pizza {
    private String[] toppings;
    private double price;

    public Pizza(String[] toppings, int numberOfToppings) {
        this.toppings = new String[numberOfToppings];
        System.arraycopy(toppings, 0, this.toppings, 0, numberOfToppings);

        // Building the description string
        StringBuilder description = new StringBuilder("Pizza with ");
        for (int i = 0; i < numberOfToppings; i++) {
            description.append(toppings[i]);
            if (i < numberOfToppings - 1) {
                description.append(", ");
            }
        }

        // Calculating the price
        this.price = 14 + 2 * numberOfToppings;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s - Price: $%.2f", String.join(", ", toppings), price);
    }
}
