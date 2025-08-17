class PalindromeCheck {

    // Check palindrome for string
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    // Check palindrome for number
    public static boolean isPalindrome(int n) {
        int original = n;
        int rev = 0;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }

        return original == rev;
    }

    public static void main(String[] args) {
        String str = "radar";
        int num = 12321;

        System.out.println("String palindrome? " + isPalindrome(str));
        System.out.println("Number palindrome? " + isPalindrome(num));
    }
}
