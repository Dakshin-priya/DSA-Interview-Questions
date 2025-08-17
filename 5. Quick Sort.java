import java.util.Arrays;

class Main {

    // Quick Sort function
    void quickSort(int[] arr, int low, int high) {
        // Only sort if the subarray has at least 2 elements
        if (low < high) {
            int pi = partition(arr, low, high); // Partition and get pivot index

            // Recursively sort elements before pivot
            quickSort(arr, low, pi - 1);

            // Recursively sort elements after pivot
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function: rearranges elements around pivot
    int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low - 1;       // Index of smaller element

        // Traverse the array and move elements smaller than pivot to left
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // Main function to test Quick Sort
    public static void main(String[] args) {
        Main sorter = new Main();
        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Call Quick Sort
        sorter.quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:   " + Arrays.toString(arr));
    }
}
