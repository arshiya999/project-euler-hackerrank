import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            System.out.println(largestPrimeFactor(n));
        }
    }

    private static long largestPrimeFactor(long n) {
        long maxPrime = -1;

        // Divide out all factors of 2
        while (n % 2 == 0) {
            maxPrime = 2;
            n /= 2;
        }

        // Divide out odd factors
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n /= i;
            }
        }

        // If n is now a prime number > 2
        if (n > 2) {
            maxPrime = n;
        }

        return maxPrime;
    }
}
