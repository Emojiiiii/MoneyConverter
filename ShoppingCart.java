import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<ItemOrder> orders; // List of item orders

    public ShoppingCart() {
        orders = new ArrayList<>();
    }

    // Adds an item order to the shopping cart
    public void addItemOrder(ItemOrder order) {
        orders.add(order);
    }

    // Removes an item order from the shopping cart based on the item
    public void removeItemOrder(Item item) {
        orders.removeIf(order -> order.getItem().equals(item));
    }

    // Searches for an item order in the cart by item name
    public ItemOrder findItemOrder(String itemName) {
        for (ItemOrder order : orders) {
            if (order.getItem().getName().equals(itemName)) {
                return order;
            }
        }
        return null; // Return null if no matching order found
    }

    // Calculates the total price of all item orders in the cart
    public double getTotalPrice() {
        double total = 0.0;
        for (ItemOrder order : orders) {
            total += order.getTotalPrice();
        }
        return total;
    }
}