public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String[] toppings, String deliveryAddress, int numberOfToppings) {
        super(toppings, numberOfToppings);
        this.deliveryAddress = deliveryAddress;

        // Setting the delivery fee based on the pizza price
        if (14 + 2 * numberOfToppings > 18) {
            this.deliveryFee = 3;
        } else {
            this.deliveryFee = 5;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Delivery Fee: $" + deliveryFee + " to address: " + deliveryAddress;
    }
}
