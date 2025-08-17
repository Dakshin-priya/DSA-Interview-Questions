void insertionSort(int[] arr) {
    int n = arr.length; // Get the size of the array

    // Outer loop: start from second element and move to the end
    // We consider arr[0..i-1] as the sorted part
    for (int i = 1; i < n; i++) {
        int key = arr[i]; // The element to be inserted in the sorted part
        int j = i - 1;   // Start comparing from the last element of sorted part

        // Move elements of arr[0..i-1], that are greater than key, one position ahead
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]; // Shift element to the right
            j--;                 // Move to the previous element
        }

        // Place key at its correct position in the sorted part
        arr[j + 1] = key;
    }
}
