package interview_preparation_kit.search.making_candies;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {
        long prod, pass = 0, sum = 0;
        while (sum < n) {
            prod = m * w;
            sum += prod;

            if ((n / 2) > sum && sum >= p) {
                long count = sum / p;
                for (long i = 1; i <= count; i++)
                    if (m < w)
                        m++;
                    else
                        w++;
                sum -= count * p;
            }
            pass++;
        }
        return pass;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] mwpn = scanner.nextLine().split(" ");
        long m = Long.parseLong(mwpn[0]);
        long w = Long.parseLong(mwpn[1]);
        long p = Long.parseLong(mwpn[2]);
        long n = Long.parseLong(mwpn[3]);
        long result = minimumPasses(m, w, p, n);
        System.out.println(result);
        scanner.close();
    }
}

