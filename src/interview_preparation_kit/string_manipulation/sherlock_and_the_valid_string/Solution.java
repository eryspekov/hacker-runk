package interview_preparation_kit.string_manipulation.sherlock_and_the_valid_string;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the isValid function below.
    public static String isValid(String s) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>(); //change to SortedMap
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            Integer value = freqMap.getOrDefault(substring, 0);
            if (0 == value) {
                Integer cVal = countMap.getOrDefault(1, 0);
                countMap.put(1, ++cVal);
            } else {
                Integer cVal = countMap.getOrDefault(value, 0);
                countMap.put(value, --cVal);
                if (0 == cVal) {
                    countMap.remove(value);
                }
                cVal = countMap.getOrDefault(value + 1, 0);
                countMap.put(value + 1, ++cVal);
            }
            freqMap.put(substring, ++value);

        }

        int size = countMap.size();
        if (size < 2)
            return "YES";
        if (size > 2)
            return "NO";

        int min = 0;
        int key = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (1 == entry.getKey() && 1 == entry.getValue())
                return "YES";
            if (0 == min) {
                min = entry.getValue();
                key = entry.getKey();
                continue;
            }
            if (min > entry.getValue()) {
                min = entry.getValue();
                if (0 == min - 1 && (key - 1) == entry.getKey())
                    return "YES";
            }
            if (0 == min - 1 && (key == (entry.getKey() - 1)))
                return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        String result = isValid("abcdefghhgfedecba");
//        String result = isValid("aaaaabc");
        System.out.println(result);
    }
}
