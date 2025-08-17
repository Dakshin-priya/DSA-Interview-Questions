import java.util.*;

public class FrequencySort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 5, 4, 3};

        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert keys to list and sort
        List<Integer> numbers = new ArrayList<>(freqMap.keySet());
        Collections.sort(numbers, (a, b) -> {
            int freqCompare = freqMap.get(a) - freqMap.get(b); // ascending frequency
            if (freqCompare == 0) return a - b;               // ascending number if freq same
            return freqCompare;
        });

        // Step 3: Print numbers repeated by their frequency
        System.out.println("Numbers sorted by frequency:");
        for (int num : numbers) {
            for (int i = 0; i < freqMap.get(num); i++) {
                System.out.print(num + " ");
            }
        }
    }
}
