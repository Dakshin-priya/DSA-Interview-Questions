import java.math.BigInteger;
import java.math.BigDecimal;

class LargeNumberAndFloatOperations {
    public static void main(String[] args) {
        // --- BigInteger Operations ---
        String intNum1Str = "12345678901234567890";
        String intNum2Str = "98765432109876543210";

        BigInteger intNum1 = new BigInteger(intNum1Str);
        BigInteger intNum2 = new BigInteger(intNum2Str);

        System.out.println("=== BigInteger Operations ===");
        System.out.println("Sum: " + intNum1.add(intNum2));
        System.out.println("Difference: " + intNum2.subtract(intNum1));
        System.out.println("Product: " + intNum1.multiply(intNum2));
        System.out.println("Quotient: " + intNum2.divide(intNum1));
        System.out.println("Remainder: " + intNum2.remainder(intNum1));

        // --- BigDecimal Operations ---
        String floatNum1Str = "12345678901234567890.12345";
        String floatNum2Str = "98765432109876543210.54321";

        BigDecimal floatNum1 = new BigDecimal(floatNum1Str);
        BigDecimal floatNum2 = new BigDecimal(floatNum2Str);

        System.out.println("\n=== BigDecimal Operations ===");
        System.out.println("Sum: " + floatNum1.add(floatNum2));
        System.out.println("Difference: " + floatNum2.subtract(floatNum1));
        System.out.println("Product: " + floatNum1.multiply(floatNum2));
        System.out.println("Quotient: " + floatNum2.divide(floatNum1, 20, BigDecimal.ROUND_HALF_UP));
    }
}
