// Heap Sort function
void heapSort(int[] arr) {
    int n = arr.length;

    // Step 1: Build a max heap from the array
    // Start from last non-leaf node and heapify each node
    for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
    }

    // Step 2: Extract elements one by one from the heap
    for (int i = n - 1; i > 0; i--) {
        // Move current root (largest) to the end
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        // Call heapify on the reduced heap
        heapify(arr, i, 0);
    }
}

// Heapify function to maintain max heap property
void heapify(int[] arr, int n, int i) {
    int largest = i;       // Initialize largest as root
    int l = 2 * i + 1;     // Left child index
    int r = 2 * i + 2;     // Right child index

    // If left child is larger than root
    if (l < n && arr[l] > arr[largest]) largest = l;

    // If right child is larger than largest so far
    if (r < n && arr[r] > arr[largest]) largest = r;

/*
    // To sort in descending order build min heap
if (l < n && arr[l] < arr[largest]) largest = l; // for min heap
if (r < n && arr[r] < arr[largest]) largest = r;
*/

    // If largest is not root, swap and continue heapifying
    if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;

        // Recursively heapify the affected subtree
        heapify(arr, n, largest);
    }
}
