import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int longestCommonSubstring(String a, String b) {

        int m = a.length();
        int n = b.length();

        int max = 0;

        int[][] mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (a.charAt(i) == b.charAt(j)) {

                    if (i == 0 || j == 0) {

                        mem[i][j] = 1;

                    } else {

                        mem[i][j] = mem[i-1][j-1] + 1;

                    }

                    if (mem[i][j] > max) {
                        max = mem[i][j];
                    }
                }

            }
        }

            
        return max;
    }
}
