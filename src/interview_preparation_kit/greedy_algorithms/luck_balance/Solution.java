package interview_preparation_kit.greedy_algorithms.luck_balance;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int res = 0;

        int[] important = new int[contests.length];
        for (int i = 0; i < contests.length; i++) {
            int amount = contests[i][0];
            int rate = contests[i][1];
            if (0 == rate)
                res += amount;
            else
                important[i] = amount;
        }
        Arrays.sort(important);
        for (int i = 0; i < important.length; i++) {
            if (i >= important.length  - k)
                res += important[i];
            else
                res -= important[i];
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
        scanner.close();
    }
}

