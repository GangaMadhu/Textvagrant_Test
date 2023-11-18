import java.util.HashMap;
import java.util.Map;

class Product {
    String name;
    double unitPrice;
    double gstRate;
    int quantity;

    public Product(String name, double unitPrice, double gstRate, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gstRate = gstRate;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity * (1 + gstRate / 100);
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        // Create a map to store product details
        Map<Integer, Product> basket = new HashMap<>();
        basket.put(1, new Product("Leather wallet", 1100, 18, 1));
        basket.put(2, new Product("Umbrella", 900, 12, 2));
        basket.put(3, new Product("Cigarette", 200, 28, 3));
        basket.put(4, new Product("Honey", 3, 2, 100));

        // Identify the product with the maximum GST amount
        double maxGSTAmount = -1;
        Product maxGSTProduct = null;

        for (Map.Entry<Integer, Product> entry : basket.entrySet()) {
            Product product = entry.getValue();
            double gstAmount = product.unitPrice * product.gstRate / 100 * product.quantity;

            if (gstAmount > maxGSTAmount) {
                maxGSTAmount = gstAmount;
                maxGSTProduct = product;
            }
        }

        System.out.println("Product with maximum GST amount: " + maxGSTProduct.name);

        // Calculate the total amount to be paid to the shopkeeper
        double totalAmount = basket.values().stream().mapToDouble(Product::getTotalPrice).sum();
        System.out.println("Total amount to be paid to the shopkeeper: Rs " + totalAmount);
    }
}