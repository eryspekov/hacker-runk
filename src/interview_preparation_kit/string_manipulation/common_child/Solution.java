package interview_preparation_kit.string_manipulation.common_child;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int res = 0;

        int i = 0;
        while (i < s1.length()) {
            int l = 0;
            int k = i;

            int j = 0;
            int f = 0;
            while (j < s2.length() && k < s1.length()) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    l++;
                    k++;
                    f = j + 1;
                }
                j++;
                if (f < s2.length() && j == s2.length() && k < s1.length() - 1 && l != 0) {
                    k++;
                    j = f;
                }
            }

            res = Math.max(res, l);
            i++;
        }

        return res;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        String s1 = scanner.nextLine();
//        String s2 = scanner.nextLine();
        int result = commonChild("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS", "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC");
        System.out.println(result);
//        scanner.close();
    }
}
