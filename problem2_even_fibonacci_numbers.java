import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        // Step 1: Precompute even Fibonacci numbers and their prefix sums
        List<Long> evens = new ArrayList<>();
        List<Long> prefix = new ArrayList<>();
        long a = 1, b = 2;
        long sum = 0;
        while (b <= 4_0000_0000_0000_0000L) {
            if (b % 2 == 0) {
                sum += b;
                evens.add(b);
                prefix.add(sum);
            }
            long c = a + b;
            a = b;
            b = c;
        }

        // Step 2: Answer queries
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine().trim());
            int idx = upperBound(evens, n); // custom binary search
            sb.append(idx >= 0 ? prefix.get(idx) : 0).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int upperBound(List<Long> list, long key) {
        int l = 0, r = list.size() - 1, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (list.get(m) <= key) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
