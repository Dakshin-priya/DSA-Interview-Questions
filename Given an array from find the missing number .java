class Solution {
    public int missingNumber(int[] nums) {
        int missingXOR = 0;  // Will store XOR of all numbers to find missing one
        
        int n = nums.length;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            missingXOR ^= i;
        }

        // XOR all numbers present in the array
        for (int num : nums) {
            missingXOR ^= num;
        }

        // The result is the missing number
        return missingXOR;
    }
}
/*
public class MissingNumber {

    public static int findMissing(int[] arr, int n) {
        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : arr) sum += num;
        return total - sum;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] arr = new int[n - 1];

        // Example: fill array with numbers 1..100 except 57
        int missing = 57;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (i != missing) arr[idx++] = i;
        }

        System.out.println("Missing number: " + findMissing(arr, n));
    }
}
*/
