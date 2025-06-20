import java.util.*;

public class ECommerceSearch {

    // Step 1: Big O Notation
    /*
     Linear Search: Time = O(n), Space = O(1)
     Binary Search: Time = O(log n), Space = O(1), requires sorted array
     */

    // Step 2: Product class
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int id, String name, String cat) {
            productId = id;
            productName = name;
            category = cat;
        }

        public String toString() {
            return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
        }
    }

    // Step 3: Linear Search using Array
    static Product linearSearch(Product[] arr, String key) {
        for (Product p : arr)
            if (p.productName.equalsIgnoreCase(key))
                return p;
        return null;
    }

    // Step 3: Binary Search (on sorted array)
    static Product binarySearch(Product[] arr, String key) {
        Arrays.sort(arr, Comparator.comparing(p -> p.productName.toLowerCase()));
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].productName.compareToIgnoreCase(key);
            if (cmp == 0) return arr[mid];
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    // Step 6: Main method with comparison
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Book", "Education"),
            new Product(104, "Shoes", "Footwear"),
            new Product(105, "Shirt", "Apparel")
        };

        System.out.print("Enter product name to search: ");
        String input = sc.nextLine();

        // Linear Search
        long start1 = System.nanoTime();
        Product result1 = linearSearch(products, input);
        long end1 = System.nanoTime();

        // Binary Search
        long start2 = System.nanoTime();
        Product result2 = binarySearch(products.clone(), input); // clone to avoid sorting original
        long end2 = System.nanoTime();

        // Results
        System.out.println("\nLinear Search Result:");
        if (result1 != null) System.out.println(result1);
        else System.out.println("Product not found.");

        System.out.println("Time: " + (end1 - start1) + " ns");

        System.out.println("\nBinary Search Result:");
        if (result2 != null) System.out.println(result2);
        else System.out.println("Product not found.");

        System.out.println("Time: " + (end2 - start2) + " ns");

        // Step 7: Analysis
        /*
         For small arrays: Linear Search is simple and fine.
         For large sorted arrays: Binary Search is faster with O(log n) time.
         For best performance with huge data: use index-based search (e.g., HashMap, DB index).
        */

        sc.close();
    }
}
