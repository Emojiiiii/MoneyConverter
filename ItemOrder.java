class ItemOrder {
    private Item item; // The item being ordered
    private int quantity; // Quantity of the item ordered

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Getter for the item
    public Item getItem() {
        return item;
    }

    // Getter for the quantity ordered
    public int getQuantity() {
        return quantity;
    }

    // Calculates the total price for this order, considering the quantity and possible bulk discounts
    public double getTotalPrice() {
        return item.getPriceForQuantity(quantity);
    }
}
