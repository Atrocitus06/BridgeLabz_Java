package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package declaration organizing OOP e-commerce demonstration.

import java.util.ArrayList;
// Importing ArrayList for dynamic product collection.

import java.util.Scanner;
// Importing Scanner for user console input.

public class EcommerceDemo {
    // Public demo class demonstrating polymorphism and encapsulation in e-commerce.

    public static void main(String[] args) {
        // Main method: program entry point.

        Scanner sc = new Scanner(System.in);
        // Scanner instance for input operations.

        ArrayList<Product> products = new ArrayList<>();
        // ArrayList storing polymorphic Product objects.

        System.out.print("Enter number of products: ");
        // Prompting total products to add.

        int n = sc.nextInt();
        // Reading product count.

        sc.nextLine();
        // Clearing newline from input buffer.

        for (int i = 0; i < n; i++) {
            // Loop for entering each product.

            System.out.println("\nProduct " + (i + 1));
            // Current product indicator.

            System.out.print("Choose Type (1-Electronics, 2-Clothing, 3-Groceries): ");
            // Type selection prompt.

            int type = sc.nextInt();
            // Capturing type (1,2,3).

            sc.nextLine();
            // Buffer clearance.

            System.out.print("Enter Product ID: ");
            // ID input prompt.

            int id = sc.nextInt();
            // Product ID as int.

            sc.nextLine();
            // Line clearance.

            System.out.print("Enter Product Name: ");
            // Name prompt.

            String name = sc.nextLine();
            // Product name string.

            System.out.print("Enter Price: ");
            // Price request.

            double price = sc.nextDouble();
            // Price as double.

            Product p;
            // Polymorphic Product reference.

            if (type == 1) {
                // Electronics case.

                p = new Electronics(id, name, price);
                // Creating Electronics instance.

            } else if (type == 2) {
                // Clothing case.

                p = new Clothing(id, name, price);
                // Creating Clothing instance.

            } else {
                // Groceries default.

                p = new Groceries(id, name, price);
                // Creating Groceries instance.
            }

            products.add(p);
            // Adding to products list.

        }  // End product input loop.

        System.out.println("\n===== FINAL PRICE DETAILS =====");
        // Results header.

        for (Product p : products) {
            // Processing each product.

            printFinalPrice(p);
            // Polymorphic price computation call.
        }

        sc.close();
        // Resource cleanup.

    }  // End main.

    // Polymorphic final price calculator.
    static void printFinalPrice(Product p) {
        // Utility method for price breakdown.

        double tax = 0;
        // Tax accumulator (0 if non-taxable).

        if (p instanceof Taxable) {
            // instanceof check for tax applicability.

            tax = ((Taxable) p).calculateTax();
            // Downcast to call tax method.
        }

        double discount = p.calculateDiscount();
        // Abstract method call (polymorphic).

        double finalPrice = p.getPrice() + tax - discount;
        // Computing net price formula.

        p.displayDetails();
        // Concrete details display.

        System.out.println("Tax: ₹" + tax);
        // Tax output.

        System.out.println("Discount: ₹" + discount);
        // Discount output.

        System.out.println("Final Price: ₹" + finalPrice);
        // Final price display.

        System.out.println("------------------------------");
        // Entry separator.
    }
    // End printFinalPrice.

}  // End EcommerceDemo.

// Abstract Product base class.
abstract class Product {
    // Common structure for all products.

    private int productId;
    // Encapsulated ID.

    private String name;
    // Encapsulated name.

    private double price;
    // Encapsulated base price.

    Product(int productId, String name, double price) {
        // Constructor initializing fields.

        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation Getters and Setters.
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Concrete method for details.
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }

    // Abstract method for polymorphic discount.
    public abstract double calculateDiscount();
}  // End Product.

// Taxable interface.
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics subclass.
class Electronics extends Product implements Taxable {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    public String getTaxDetails() {
        return "18% GST";
    }
}

// Clothing subclass.
class Clothing extends Product implements Taxable {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    public String getTaxDetails() {
        return "5% GST";
    }
}

// Groceries subclass (no tax).
class Groceries extends Product {
    Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
