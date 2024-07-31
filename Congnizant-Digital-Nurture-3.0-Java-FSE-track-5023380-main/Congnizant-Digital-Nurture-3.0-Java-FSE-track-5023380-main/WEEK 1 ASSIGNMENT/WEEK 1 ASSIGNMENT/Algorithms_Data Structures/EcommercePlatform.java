/*Big O Notation:
Big O notation is a mathematical notation that describes the upper limit of the time complexity of an algorithm. It gives us an idea of how the runtime of an algorithm grows as the input size grows. Big O notation helps in comparing the efficiency of different algorithms.

O(1): Constant time - The algorithm takes the same amount of time regardless of the input size.
O(log n): Logarithmic time - The algorithm's runtime grows logarithmically with the input size.
O(n): Linear time - The algorithm's runtime grows linearly with the input size.
O(n log n): Linearithmic time - The algorithm's runtime grows linearly with a logarithmic factor. */

/*Best Case: The scenario where the search operation takes the least amount of time.
Average Case: The scenario where the search operation takes an average amount of time.
Worst Case: The scenario where the search operation takes the maximum amount of time. */

import java.util.Arrays;
import java.util.Comparator;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class LinearSearch {
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Product binarySearch(Product[] products, int productId) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Smartphone", "Electronics"),
                new Product(3, "Tablet", "Electronics"),
                new Product(4, "Headphones", "Accessories"),
                new Product(5, "Keyboard", "Accessories")
        };

        // Linear Search
        Product result1 = LinearSearch.linearSearch(products, 3);
        System.out.println("Linear Search Result: " + result1);

        // Binary Search
        Product result2 = BinarySearch.binarySearch(products, 3);
        System.out.println("Binary Search Result: " + result2);
    }
}
// Analysis
/*
 * Time Complexity:
 * Linear Search:
 * 
 * Best Case: O(1) (when the element is the first one in the array)
 * Average Case: O(n/2) ≈ O(n)
 * Worst Case: O(n) (when the element is the last one or not present)
 * Binary Search:
 * 
 * Best Case: O(1) (when the middle element is the target)
 * Average Case: O(log n)
 * Worst Case: O(log n)
 */

// Suitable Algoritm
/*
 * Linear Search is suitable for small arrays or unsorted data. It is simple to
 * implement but not efficient for large datasets.
 * Binary Search is suitable for large sorted arrays. It is much faster than
 * linear search but requires the array to be sorted.
 */