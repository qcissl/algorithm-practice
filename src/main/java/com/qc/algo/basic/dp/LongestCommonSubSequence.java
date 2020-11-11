package com.qc.algo.basic.dp;

/**
 * description
 *
 * @author qinc 2020/11/11 10:22
 */
public class LongestCommonSubSequence {

    public static int longest(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = Math.max(dp[i][0], 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(0)) {
                dp[0][i] = Math.max(dp[0][i], 1);
            }
        }

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[str1.length() - 1][str2.length() - 1];
    }

    public static void main(String[] args) {
        String str1 = "sdy1sefg547457j5rttk3";
        String str2 = "sddddy1sesdg547547777777dfgj5rtgggtk3eeee";
        System.out.println(longest(str1, str2));
    }
}
