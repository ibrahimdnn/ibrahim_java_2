public class Lunchbox {
    private String customerName;
    private String mainItem;
    private int quantity;
    private double price;
    private boolean isDelivered;

    public Lunchbox() {
        this.isDelivered = false;
    }

    public Lunchbox(String name, String item, int qty, double price) {
        this.customerName = name;
        this.mainItem = item;
        this.quantity = qty;
        this.price = price;
        this.isDelivered = false;
    }

    public void setQuantity(int qty) { this.quantity = qty; }
    public void setDelivered(boolean status) { this.isDelivered = status; }

    public double calculateCost() {
        return this.price * this.quantity;
    }

    public void displayOrder() {
        String status = isDelivered ? "Delivered" : "Pending";
        System.out.println("Customer: " + customerName + " | Item: " + mainItem + " | Qty: " + quantity + " | Total: $" + String.format("%.2f", calculateCost()) + " | Status: " + status);
    }
}