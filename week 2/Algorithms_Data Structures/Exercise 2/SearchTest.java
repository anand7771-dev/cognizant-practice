import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {

    public static Product linearSearch(Product[] products, int id) {

        for (int i = 0; i < products.length; i++) {

            if (products[i].productId == id) {
                return products[i];
            }

        }

        return null;
    }

    public static Product binarySearch(Product[] products, int id) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == id) {
                return products[mid];
            }

            if (products[mid].productId < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(105, "Mouse", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(102, "Watch", "Accessories"),
                new Product(104, "Bag", "Travel")
        };

        System.out.println("Linear Search");

        Product p1 = linearSearch(products, 102);

        if (p1 != null) {
            p1.display();
        } else {
            System.out.println("Product Not Found");
        }

        Arrays.sort(products, new Comparator<Product>() {

            public int compare(Product a, Product b) {
                return a.productId - b.productId;
            }

        });

        System.out.println();

        System.out.println("Binary Search");

        Product p2 = binarySearch(products, 102);

        if (p2 != null) {
            p2.display();
        } else {
            System.out.println("Product Not Found");
        }

    }

}