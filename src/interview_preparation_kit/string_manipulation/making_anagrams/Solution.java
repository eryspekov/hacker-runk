package interview_preparation_kit.string_manipulation.making_anagrams;

import java.io.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int res = 0;

        int[] chars = new int[100];

        for (char c : a.toCharArray())
            chars[Character.getNumericValue(c)]++;

        for (char c : b.toCharArray())
            chars[Character.getNumericValue(c)]--;

        for (int c : chars) {
            res += Math.abs(c);
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        int res = makeAnagram("cde", "abc");
        System.out.println(res);
    }
}
