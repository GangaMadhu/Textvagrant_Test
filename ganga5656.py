class Product:
    def _init_(self, name, unit_price, gst_rate, quantity):
        self.name = name
        self.unit_price = unit_price
        self.gst_rate = gst_rate
        self.quantity = quantity

# Create products in the basket
leather_wallet = Product("Leather Wallet", 1100, 18, 1)
umbrella = Product("Umbrella", 900, 12, 2)
cigarette = Product("Cigarette", 200, 28, 3)
honey = Product("Honey", 3, 2, 100)

# Put products in the basket
basket = [leather_wallet, umbrella, cigarette, honey]

# Problem 1: Identify the product for which we paid the maximum GST amount
max_gst_product = max(basket, key=lambda x: x.unit_price * x.gst_rate * x.quantity)
print("Product with maximum GST amount:", max_gst_product.name)

# Problem 2: Calculate the total amount to be paid to the shopkeeper
total_amount = sum((product.unit_price + product.unit_price * product.gst_rate / 100) * product.quantity for product in basket)
print("Total amount to be paid to the shopkeeper:", total_amount)