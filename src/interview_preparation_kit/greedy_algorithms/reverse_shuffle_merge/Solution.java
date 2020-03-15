package interview_preparation_kit.greedy_algorithms.reverse_shuffle_merge;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        int a = 'a';
        int[] frequency = new int[26];
        s.chars().forEach(c -> frequency[c - a]++);
        int[] count = Arrays.stream(frequency).map(f -> f / 2).toArray();

        int top = -1;
        int[] stack = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - a;
            frequency[c]--;
            if (count[c] < 1)
                continue;

            count[c]--;
            while (top >= 0 &&
                    stack[top] > c &&
                    frequency[stack[top]] > count[stack[top]]) {
                count[stack[top--]]++;
            }
            stack[++top] = c;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i <= top; i++)
            str.append((char) (stack[i] + a));
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        String result = reverseShuffleMerge("abcdefgabcdefg");
        System.out.println(result);
    }

}
