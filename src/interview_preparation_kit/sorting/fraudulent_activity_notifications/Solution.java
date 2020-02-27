package interview_preparation_kit.sorting.fraudulent_activity_notifications;

import java.io.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications2(int[] expenditure, int d) {

        int[] arr = new int[201];
        for (int i = 0; i < d; i++) {
            arr[expenditure[i]]++;
        }
        int res = 0;
        for (int i = d; i < expenditure.length; i++) {
            int lower = 0;
            int leftNum = 0;
            while ((leftNum + arr[lower]) * 2 <= d) {
                leftNum += arr[lower];
                lower++;
            }
            int upper = arr.length - 1;
            int rightNum = 0;
            while ((rightNum + arr[upper]) * 2 <= d) {
                rightNum += arr[upper];
                upper--;
            }

            if (expenditure[i] >= lower + upper)
                res++;
            arr[expenditure[i - d]]--;
            arr[expenditure[i]]++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        int result = activityNotifications2(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5);

        System.out.println(result);
    }
}

