import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isPrime(n)) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }

        sc.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;  // 0 and 1 are not prime

        // Check divisors from 2 to sqrt(n)
        double sqrtN = Math.sqrt(n);
        // for (int i = 2; i * i <= n; i++) 
        for (int i = 2; i <= sqrtN; i++) 
        {
            if (n % i == 0) return false;  // divisible → not prime
        }
        return true;  // no divisors → prime
    }
}
