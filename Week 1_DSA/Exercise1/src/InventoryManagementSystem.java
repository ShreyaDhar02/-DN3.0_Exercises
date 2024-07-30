import java.util.HashMap;

public class InventoryManagementSystem {
    private final HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found");
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product product1 = new Product(1, "Geometry box", 15, 180.00);
        Product product2 = new Product(2, "Ruler", 50, 15.00);

        ims.addProduct(product1);
        ims.addProduct(product2);

        Product product = ims.getProduct(1);
        if (product != null) {
            System.out.println(product.getProductName());
        }

        Product updatedProduct = new Product(1, "Marker", 5, 150.99);
        ims.updateProduct(1, updatedProduct);

        Product updatedProduct2 = new Product(2, "Eraser", 12, 2.99);
        ims.updateProduct(2, updatedProduct2);

        ims.deleteProduct(2);

        Product product3 = ims.getProduct(2);
        if (product3 != null) {
            System.out.println(product3.getProductName());
        } else {
            System.out.println("Product not found");
        }
    }
}
