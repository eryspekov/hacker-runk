package interview_preparation_kit.sorting.counting_inversions;

import java.io.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int[] sorted, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return 0;

        long result = 0;
        int middle = (leftStart + rightEnd) / 2;
        result += mergeSort(arr, sorted, leftStart, middle);
        result += mergeSort(arr, sorted, middle + 1, rightEnd);

        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = middle + 1;
        int index = leftStart;
        while (left <= middle && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                sorted[index] = arr[left];
                left++;
            } else {
                result += middle - left + 1;
                sorted[index] = arr[right];
                right++;
            }
            index++;
        }
        System.arraycopy(arr, left, sorted, index, middle - left + 1);
        System.arraycopy(arr, right, sorted, index, rightEnd - right + 1);
        System.arraycopy(sorted, leftStart, arr, leftStart, size);
        return result;
    }

    public static void main(String[] args) throws IOException {
        long result = countInversions(new int[]{2, 1, 3, 1, 2});
        System.out.println(result);
    }
}
