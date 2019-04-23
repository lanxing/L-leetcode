/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (35.86%)
 * Total Accepted:    2.1K
 * Total Submissions: 5.7K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * 
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (s3.length() != len1 + len2){
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len2; ++i){
            if (s2.charAt(i - 1) == s3.charAt(i - 1)){
                dp[0][i] = dp[0][i - 1];
            }else {
                dp[0][i] = false;
            }
        }
        for (int i = 1; i <= len1; ++i){
            if (s1.charAt(i - 1) == s3.charAt(i - 1)){
                dp[i][0] = dp[i - 1][0];
            }else {
                dp[i][0] = false;
            }
        }

        for (int i = 1; i <= len1; ++i){
            for (int j = 1; j <= len2; ++j){
                char c3 = s3.charAt(i + j - 1);
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c3 != c1 && c3 != c2){
                    dp[i][j] = false;
                }else if (c3 == c1 && c3 == c2){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else if (c3 == c1){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }
        return dp[len1][len2];
    }
}
