public class HeapSort {

    // Function to perform heapify operation
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // Check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger than root
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Main function to perform heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract elements
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        // Generating an array with 10000 random integers
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }

        // Measuring the time taken to sort the array
        long startTime = System.currentTimeMillis();
        heapSort(arr);
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken for sorting 10000 elements: " + (endTime - startTime) + " milliseconds");
    }
}
