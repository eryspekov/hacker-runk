package interview_preparation_kit.search.minimum_time_required;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        long minDays = 0;
        long maxDays = machines[machines.length - 1] * goal;
        while (minDays != maxDays) {
            long mid = (minDays + maxDays) / 2;
            long prod = 0;
            for (long machine : machines)
                prod += mid / machine;
            if (prod >= goal)
                maxDays = mid;
            else
                minDays = mid + 1;
        }
        return minDays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        scanner.close();
    }
}
