package Object_Oriented_Programming.Association_Aggregation;

import java.util.ArrayList;

/* ---------- PRODUCT CLASS ---------- */
class Product {

    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    void displayProduct() {
        System.out.println("  Product: " + productName + " | Price: " + price);
    }
}

/* ---------- ORDER CLASS (AGGREGATES PRODUCTS) ---------- */
class Order {

    int orderId;
    ArrayList<Product> products = new ArrayList<>();

    Order(int orderId) {
        this.orderId = orderId;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        for (Product p : products) {
            p.displayProduct();
        }
    }
}

/* ---------- CUSTOMER CLASS (ASSOCIATION + COMMUNICATION) ---------- */
class Customer {

    String name;

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order order) {
        System.out.println("\nCustomer " + name + " placed Order " + order.orderId);
        order.displayOrderDetails();
    }
}

/* ---------- MAIN CLASS (SAME FILE) ---------- */
class EcommercePlatform {

    public static void main(String[] args) {

        // Products (independent)
        Product p1 = new Product("Laptop", 65000);
        Product p2 = new Product("Mouse", 800);
        Product p3 = new Product("Keyboard", 1500);

        // Order aggregates products
        Order order1 = new Order(101);
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.addProduct(p3);

        // Customer places order (association + communication)
        Customer customer = new Customer("Aarav");
        customer.placeOrder(order1);
    }
}
