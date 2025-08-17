void selectionSort(int[] arr) {
    int n = arr.length; // Get the size of the array

    // Outer loop: iterate over each position where we want to place the minimum element
    for (int i = 0; i < n - 1; i++) {

        int minIdx = i; // Assume the current position holds the minimum

        // Inner loop: find the minimum element in the unsorted part of the array
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j; // Update minIdx if a smaller element is found
            }
        }

        // Swap the found minimum element with the element at the current position
        int temp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = temp;
    }
}
