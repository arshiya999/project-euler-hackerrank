import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(bufferedReader.readLine().trim());

            long result = sumDivisibleBy(N - 1, 3) + sumDivisibleBy(N - 1, 5) - sumDivisibleBy(N - 1, 15);
            System.out.println(result);
        }

        bufferedReader.close();
    }

    // Function to calculate sum of multiples of 'k' below 'n'
    private static long sumDivisibleBy(long n, long k) {
        long p = n / k;
        return k * p * (p + 1) / 2;
    }
}
