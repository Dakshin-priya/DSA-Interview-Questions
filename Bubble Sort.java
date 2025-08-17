void bubbleSort(int[] arr) {
    int n = arr.length; // Get the size of the array

    // Outer loop: number of passes
    // After each pass, the largest element among unsorted elements "bubbles" to its correct position
    for (int i = 0; i < n - 1; i++) {

        // Inner loop: compare adjacent elements
        // We go up to n-i-1 because the last i elements are already sorted
        for (int j = 0; j < n - i - 1; j++) {

            // If the current element is greater than the next element, swap them
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];      // Store current element in temp
                arr[j] = arr[j + 1];    // Move next element to current position
                arr[j + 1] = temp;      // Move temp (original current element) to next position
            }
        }
    }
}
