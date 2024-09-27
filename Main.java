public class Main {
    public static void main(String[] args) {
        // Create some items
        Item tissues = new Item("Tissues", 3.0);
        Item soap = new Item("Soap", 2.0, 2, 3.5); // Bulk discount: 2 for $3.5
        
        // Create item orders
        ItemOrder tissuesOrder = new ItemOrder(tissues, 5); // Ordering 5 boxes of tissues
        ItemOrder soapOrder = new ItemOrder(soap, 3); // Ordering 3 soaps, 2 will get bulk price, 1 regular price
        
        // Create a shopping cart and add the item orders
        ShoppingCart cart = new ShoppingCart();
        cart.addItemOrder(tissuesOrder);
        cart.addItemOrder(soapOrder);
        
        // Calculate and print the total price of the shopping cart
        double totalPrice = cart.getTotalPrice();
        System.out.println("The total price of the shopping cart is $" + totalPrice);
    }
}
