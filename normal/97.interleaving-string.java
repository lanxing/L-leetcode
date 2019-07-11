package lalgorithm.normal;

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
 * 动态规划：dp[i][j] 代表是A的前i个字符与C中匹配，B中前j个字符与C中匹配
 * 判断dp[i][j]只需要判断左边和上边是否匹配
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int le3 = s3.length();
        if (le3 != len1 + len2){
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; ++i){
            for (int j = 0; j <= len2; ++j){
                if (i > 0 && dp[i - 1][j]){
                    //上边匹配，则s1的第i个字符需和s3匹配
                    dp[i][j] = s1.charAt( i - 1) == s3.charAt( i + j - 1);
                }else if (j > 0 && dp[i][j - 1]){
                    //左边匹配，则s2的第j个字符需要和s3匹配
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }else if (i != 0 || j != 0){
                    dp[i][j] = false;
                }
            }
        }
        return dp[len1][len2];
    }
}
