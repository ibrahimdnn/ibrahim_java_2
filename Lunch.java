import java.util.Scanner;

public class Lunch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Lunchbox[] orders = new Lunchbox[10]; 
        int orderCount = 0;
        int choice = 0;

        do {
            System.out.println("\n--- Ibrahim's Lunch Tracker ---");
            System.out.println("1. Add NEW order");
            System.out.println("2. Add quantity to an order");
            System.out.println("3. Mark order as delivered");
            System.out.println("4. Calculate total sales");
            System.out.println("5. Exit");
            System.out.print("Enter choice (Numbers 1-5 only): ");
            
            choice = input.nextInt();
            input.nextLine(); // Clear buffer

            switch(choice) {
                case 1:
                    if(orderCount < 10) {
                        System.out.print("Customer Name: ");
                        String name = input.nextLine();
                        System.out.print("Item: ");
                        String item = input.nextLine();
                        System.out.print("Price: ");
                        double price = input.nextDouble();
                        
                        orders[orderCount] = new Lunchbox(name, item, 1, price);
                        orderCount++;
                        System.out.println("Order added successfully!");
                    } else {
                        System.out.println("Order list is full!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Order Number (1-" + orderCount + "): ");
                    int qNum = input.nextInt() - 1;
                    if(qNum >= 0 && qNum < orderCount && orders[qNum] != null) {
                        System.out.print("Enter new quantity: ");
                        orders[qNum].setQuantity(input.nextInt());
                        System.out.println("Quantity updated.");
                    } else {
                        System.out.println("Invalid order number. Add an order first!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Order Number to mark delivered: ");
                    int dNum = input.nextInt() - 1;
                    if(dNum >= 0 && dNum < orderCount && orders[dNum] != null) {
                        orders[dNum].setDelivered(true);
                        System.out.println("Order marked as delivered.");
                    } else {
                        System.out.println("Invalid order number. Add an order first!");
                    }
                    break;

                case 4:
                    double totalSales = 0;
                    System.out.println("\n--- Ibrahim's Current Orders ---");
                    for(int i = 0; i < orderCount; i++) {
                        System.out.print((i + 1) + ". "); 
                        orders[i].displayOrder();
                        totalSales += orders[i].calculateCost();
                    }
                    System.out.println("TOTAL REVENUE: $" + String.format("%.2f", totalSales));
                    break;
            }
        } while (choice != 5);

        System.out.println("System Closed. Goodbye, Ibrahim!");
        input.close(); 
    }
}