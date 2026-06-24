package dsa;

public class EcommerceSearch {

    static class Product {
        int productId;
        String productName;
        String category;

        Product(int id, String name, String cat) {
            this.productId = id;
            this.productName = name;
            this.category = cat;
        }
    }

    static int linearSearch(Product[] products, int id) {
        for (int i = 0; i < products.length; i++)
            if (products[i].productId == id) return i;
        return -1;
    }

    static int binarySearch(Product[] products, int id) {
        int start = 0, end = products.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (products[mid].productId == id) return mid;
            if (products[mid].productId < id) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Book", "Education")
        };

        System.out.println("Linear Search: Index " + linearSearch(products, 102));
        System.out.println("Binary Search: Index " + binarySearch(products, 102));
    }
}