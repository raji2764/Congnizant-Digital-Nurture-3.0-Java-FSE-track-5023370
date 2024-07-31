/*Bubble Sort:
Bubble Sort is a simple comparison-based sorting algorithm where each pair of adjacent elements is compared,
 and the elements are swapped if they are in the wrong order. This process is repeated until the list is sorted. */
/*Insertion Sort:
Insertion Sort builds the final sorted array one item at a time. 
It is much less efficient on large lists than more advanced algorithms such as Quick Sort, Merge Sort, or Heap Sort. */
/*Quick Sort:
Quick Sort is a divide-and-conquer algorithm. It works by selecting a 'pivot' element from the array and 
partitioning the other elements into two sub-arrays according to whether they are less than or greater than the pivot. */
/*Merge Sort:
Merge Sort is a stable, comparison-based, divide-and-conquer sorting algorithm. It divides the unsorted list into n sublists, 
each containing one element, and then repeatedly merges sublists to produce new sorted sublists until there is only one sublist remaining. */

public class Sorting {
    static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public String getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId='" + orderId + '\'' +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders) {
        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = new Order[] {
                new Order("1", "John Doe", 100.0),
                new Order("2", "Jane Doe", 50.0),
                new Order("3", "Bob Smith", 200.0)
        };
        System.out.println("Before sorting:");
        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println("\nSorting using Bubble Sort:");
        bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }
        Order[] orders2 = new Order[] {
                new Order("1", "John Doe", 100.0),
                new Order("2", "Jane Doe", 50.0),
                new Order("3", "Bob Smith", 200.0)
        };
        System.out.println("\nSorting using Quick Sort:");
        quickSort(orders2);
        for (Order order : orders2) {
            System.out.println(order);
        }
    }
}
// Analysis
/*
 * Time Complexity Comparison:
 * Bubble Sort:
 * Worst-case: O(n^2)
 * Average-case: O(n^2)
 * Best-case: O(n)
 * Quick Sort:
 * Worst-case: O(n^2) (rare, depends on pivot selection)
 * Average-case: O(n log n)
 * Best-case: O(n log n)
 */

/*
 * Why Quick Sort is Generally Preferred:
 * Efficiency: Quick Sort is more efficient on average compared to Bubble Sort,
 * especially for large datasets.
 * Divide and Conquer: Quick Sort uses a divide-and-conquer approach, making it
 * faster and more efficient for sorting large arrays.
 */