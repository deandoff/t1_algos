package org.example.task7;


import java.util.*;

public class Main {

    public static String[] findSubsequences(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        Set<String> result = new HashSet<>();
        findAll(s1, s2, n, m, dp, "", result);

        return result.toArray(new String[0]);
    }

    private static void findAll(
            String s1, String s2,
            int i, int j,
            int[][] dp,
            String current,
            Set<String> result) {

        if (i == 0 || j == 0) {
            result.add(new StringBuilder(current).reverse().toString());
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            findAll(s1, s2, i - 1, j - 1, dp, current + s1.charAt(i - 1), result);
        } else {

            if (dp[i - 1][j] == dp[i][j]) {
                findAll(s1, s2, i - 1, j, dp, current, result);
            }

            if (dp[i][j - 1] == dp[i][j]) {
                findAll(s1, s2, i, j - 1, dp, current, result);
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "ABDEFADRFG";
        String s2 = "DAFERG";

        System.out.println(
                Arrays.toString(findSubsequences(s1, s2))
        );
    }
}
