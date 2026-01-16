package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

public class OrderTest {
// Public class declaration for OrderTest as the main demonstration class for order status inheritance.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins and user creates DeliveredOrder.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        System.out.print("Enter Order ID: ");
// Prompting the user to enter the order ID.

        int orderId = sc.nextInt();
// Reading an integer input (order ID) and storing in local variable.

        sc.nextLine();
// Consuming the newline character left in the input buffer after nextInt().

        System.out.print("Enter Order Date: ");
// Prompting the user to enter the order date.

        String orderDate = sc.nextLine();
// Reading a line of input (order date) and storing in local variable.

        System.out.print("Enter Tracking Number: ");
// Prompting the user to enter the tracking number.

        String trackingNumber = sc.nextLine();
// Reading a line of input (tracking number) and storing in local variable.

        System.out.print("Enter Delivery Date: ");
// Prompting the user to enter the delivery date.

        String deliveryDate = sc.nextLine();
// Reading a line of input (delivery date) and storing in local variable.

        DeliveredOrder order = new DeliveredOrder(
            orderId,
            orderDate,
            trackingNumber,
            deliveryDate
        );
// Creating a DeliveredOrder object instance with all parameters (deepest subclass).

        System.out.println("\n--- Order Details ---");
// Printing a formatted header for order details output.

        System.out.println("Order Status: " + order.getOrderStatus());
// Calling overridden getOrderStatus() on order object; returns "Order Delivered".

        sc.close();
// Closing the Scanner to prevent resource leak (good practice).

    } // End of main method.

    class Order {
// Inner class declaration for Order as the superclass/base class for order lifecycle.

        int orderId;
// Instance variable to store the unique order identifier.

        String orderDate;
// Instance variable to store the order placement date.

        Order(int orderId, String orderDate) {
// Constructor declaration that initializes basic order fields.

            this.orderId = orderId;
// Assigning parameter to instance variable (distinguished by 'this').

            this.orderDate = orderDate;
// Assigning parameter to instance variable (distinguished by 'this').

        } // End of Order constructor.

        String getOrderStatus() {
// Method declaration providing default status for newly placed orders.

            return "Order Placed";
// Returning string indicating initial order status.

        } // End of getOrderStatus method in superclass.

    } // End of Order superclass.

    // Subclass
    class ShippedOrder extends Order {
// Inner class declaration for ShippedOrder subclass that inherits from Order superclass.

        String trackingNumber;
// Subclass-specific instance variable for shipment tracking.

        ShippedOrder(int orderId, String orderDate, String trackingNumber) {
// Constructor declaration that chains to superclass and sets subclass field.

            super(orderId, orderDate);
// Calling superclass Order constructor with basic parameters.

            this.trackingNumber = trackingNumber;
// Assigning parameter to subclass instance variable.

        } // End of ShippedOrder constructor.

        String getOrderStatus() {
// Overriding superclass getOrderStatus() with shipped status.

            return "Order Shipped";
// Returning string indicating shipped order status.

        } // End of overridden getOrderStatus method in ShippedOrder.

    } // End of ShippedOrder subclass.

    // Subclass
    class DeliveredOrder extends ShippedOrder {
// Inner class declaration for DeliveredOrder subclass that inherits from ShippedOrder superclass.

        String deliveryDate;
// Subclass-specific instance variable for delivery completion date.

        DeliveredOrder(int orderId, String orderDate,
            String trackingNumber, String deliveryDate) {
// Constructor declaration that chains to parent ShippedOrder constructor.

            super(orderId, orderDate, trackingNumber);
// Calling superclass ShippedOrder constructor with first three parameters.

            this.deliveryDate = deliveryDate;
// Assigning parameter to subclass instance variable.

        } // End of DeliveredOrder constructor.

        String getOrderStatus() {
// Overriding parent getOrderStatus() with final delivered status.

            return "Order Delivered";
// Returning string indicating delivered order status.

        } // End of overridden getOrderStatus method in DeliveredOrder.

    } // End of DeliveredOrder subclass.

} // End of OrderTest class.
