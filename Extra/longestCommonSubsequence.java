import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int longestCommonSubsequence(String a, String b) {

      int m = a.length();
      int n = b.length();

      int[][] mem = new int[m+1][n+1];

      for (int i = 0; i <= m; i++) {
        for (int j = 0; j <= n; j++) {

          if (i == 0 || j == 0) {

            mem[i][j] = 0;

          } else if (a.charAt(i-1) == b.charAt(j-1)) {

            mem[i][j] = mem[i-1][j-1] + 1;

          } else {

            mem[i][j] = Math.max( mem[i-1][j], mem[i][j-1] );

          }

        }
      }

      return mem[m][n];
    }
}
