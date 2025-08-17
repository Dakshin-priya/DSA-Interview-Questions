import java.util.*;

class AllPalindromes {

    // Expand around center
    static void expand(String s, int left, int right, Set<String> result) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result.add(s.substring(left, right + 1));
            left--;
            right++;
        }
    }

    public static Set<String> allPalindromes(String s) {
        Set<String> result = new HashSet<>(); // Use set to avoid duplicates

        for (int i = 0; i < s.length(); i++) {
            // Odd length
            expand(s, i, i, result);
            // Even length
            expand(s, i, i + 1, result);
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "ababa";
        Set<String> palindromes = allPalindromes(str);

        System.out.println("All palindromic substrings:");
        for (String p : palindromes) {
            System.out.println(p);
        }
    }
}
