class SwapNumbers {
    public static void main(String[] args) {
        int a = 5, b = 10;

        System.out.println("Original: a = " + a + ", b = " + b);

        // 1️⃣ Using addition and subtraction
        a = a + b; // a now becomes 15
        b = a - b; // b = 15 - 10 = 5
        a = a - b; // a = 15 - 5 = 10
        System.out.println("Swap using addition/subtraction: a = " + a + ", b = " + b);

        // Reset values
        a = 5; b = 10;

        // 2️⃣ Using multiplication and division (only if a,b != 0)
        a = a * b; // a = 50
        b = a / b; // b = 50 / 10 = 5
        a = a / b; // a = 50 / 5 = 10
        System.out.println("Swap using multiplication/division: a = " + a + ", b = " + b);

        // Reset values
        a = 5; b = 10;

        // 3️⃣ Using XOR bitwise operator
        a = a ^ b; // a = 5 ^ 10
        b = a ^ b; // b = (5^10) ^ 10 = 5
        a = a ^ b; // a = (5^10) ^ 5 = 10
        System.out.println("Swap using XOR: a = " + a + ", b = " + b);

    }
}
