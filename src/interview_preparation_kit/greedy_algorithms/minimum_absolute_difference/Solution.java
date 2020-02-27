package interview_preparation_kit.greedy_algorithms.minimum_absolute_difference;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
            Arrays.sort(arr);
            int min = Math.abs(arr[0] - arr[1]);
            for (int i = 1; i < arr.length - 1; i++) {
                int abs = Math.abs(arr[i] - arr[i + 1]);
                min = Math.min(min, abs);
            }
            return min;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = {3, -7, 0};
        int result = minimumAbsoluteDifference(arr);
        System.out.println(result);
    }
}
