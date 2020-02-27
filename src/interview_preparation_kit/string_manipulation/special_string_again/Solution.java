package interview_preparation_kit.string_manipulation.special_string_again;

import java.io.*;
import java.util.*;

public class Solution {

    static long substrCount(int n, String s) {
        long res = 0;
        for (int cur = 0; cur < n; cur++) {
            res++;
            int next = cur + 1;
            while (next < n && s.charAt(cur) == s.charAt(next))
                next++;
            int length = next - cur;
            if (next > cur + 1)
                res += length - 1;

            int end = n - 1;
            boolean isEqual = (next < end) && (length <= end - next);
            for (int k = 1; k <= length && next + k < n && isEqual; k++)
                isEqual = s.charAt(cur) == s.charAt(next + k);

            if (isEqual)
                res++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long result = substrCount(s.length(), s);
        System.out.println(result);
        scanner.close();
    }
}
