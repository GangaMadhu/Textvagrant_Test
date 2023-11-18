import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private int unitPrice;
    private int gst;
    private int quantity;

    public Product(String name, int unitPrice, int gst, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public int calculateTotalGST() {
        return unitPrice * gst * quantity / 100;
    }

    public int calculateTotalAmount() {
        return unitPrice * quantity;
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductWithMaxGST() {
        Product maxGSTProduct = null;
        int maxGSTAmount = 0;

        for (Product product : products) {
            int gstAmount = product.calculateTotalGST();
            if (gstAmount > maxGSTAmount) {
                maxGSTAmount = gstAmount;
                maxGSTProduct = product;
            }
        }

        return maxGSTProduct;
    }

    public int calculateTotalAmountToPay() {
        int totalAmount = 0;

        for (Product product : products) {
            totalAmount += product.calculateTotalAmount();
        }

        // Apply 5% discount for products with unit price >= Rs 500
        for (Product product : products) {
            if (product.getUnitPrice() >= 500) {
                totalAmount -= product.calculateTotalAmount() * 0.05;
            }
        }

        return totalAmount;
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // Adding products to the basket
        shoppingCart.addProduct(new Product("Leather Wallet", 1100, 18, 1));
        shoppingCart.addProduct(new Product("Umbrella", 900, 12, 2));
        shoppingCart.addProduct(new Product("Cigarette", 200, 28, 3));
        shoppingCart.addProduct(new Product("Honey", 4, 0, 100));

        // 1. Identify the product for which we paid maximum GST amount
        Product maxGSTProduct = shoppingCart.getProductWithMaxGST();
        System.out.println("Product with maximum GST: " + maxGSTProduct.getName());

        // 2. Calculate the total amount to be paid to the shopkeeper
        int totalAmountToPay = shoppingCart.calculateTotalAmountToPay();
        System.out.println("Total amount to pay: Rs " + totalAmountToPay);
    }
}