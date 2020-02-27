package interview_preparation_kit.string_manipulation.alternating_characters;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int res = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, 1);
        for (int i = 1; i < s.length(); i++) {
            String prev = sb.substring(sb.length() - 1, sb.length());
            String substring = s.substring(i, i + 1);
            if (prev.equals(substring)) {
                res++;
                continue;
            }
            sb.append(substring);
        }
        return res;

    }

    public static void main(String[] args) throws IOException {
        int result = alternatingCharacters("AAABBB");
        System.out.println(result);
    }
}
