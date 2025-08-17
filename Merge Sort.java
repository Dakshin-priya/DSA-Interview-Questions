import java.util.Arrays;

class Main {

    // Merge Sort function
    void mergeSort(int arr[]) {
        // Base condition: array has more than 1 element
        if (arr.length > 1) {
            int mid = arr.length / 2; // Find middle index

            // Split the array into left and right halves
            int left[] = Arrays.copyOfRange(arr, 0, mid);
            int right[] = Arrays.copyOfRange(arr, mid, arr.length);

            // Recursively sort left and right halves
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted halves back into original array
            merge(arr, left, right);
        }
    }

    // Merge two sorted arrays (left and right) into arr
    int[] merge(int arr[], int left[], int right[]) {
        int i = 0; // index for left array
        int j = 0; // index for right array
        int k = 0; // index for merged array (arr)

        // Merge elements while both arrays have elements
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left array (if any)
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array (if any)
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return arr; // Return the merged array
    }

    // Example usage
    public static void main(String[] args) {
        Main sorter = new Main();
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        sorter.mergeSort(arr);
        System.out.println(Arrays.toString(arr)); // Sorted array
    }
}
