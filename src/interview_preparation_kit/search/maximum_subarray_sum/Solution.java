package interview_preparation_kit.search.maximum_subarray_sum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        long sum = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            sum = (sum + a[i]) % m;
            a[i] = sum;
            max = Math.max(max, sum);
        }
        TreeSet<Long> set = new TreeSet<>();
        for (long x : a) {
            Long higher = set.higher(x);
            if (higher != null) {
                max = Math.max(max, (x - higher + m) % m);
            }
            set.add(x);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

        }

        scanner.close();
    }
}
