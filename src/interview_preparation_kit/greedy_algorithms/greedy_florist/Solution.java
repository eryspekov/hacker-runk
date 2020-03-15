package interview_preparation_kit.greedy_algorithms.greedy_florist;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int res = 0;
        Arrays.sort(c);
        int m = 0, j = k;
        for (int i = c.length - 1; i >= 0; i--) {
            int price = c[i];
            price = (m + 1) * price;
            if (j > 0)
                j--;
            res += price;
            if (0 == j) {
                m++;
                j = k;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        int minimumCost = getMinimumCost(3, new int[]{1, 3, 5, 7, 9});
        System.out.println(minimumCost);
    }
}

