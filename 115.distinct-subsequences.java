/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 *
 * https://leetcode-cn.com/problems/distinct-subsequences/description/
 *
 * algorithms
 * Hard (43.03%)
 * Total Accepted:    2.7K
 * Total Submissions: 6.2K
 * Testcase Example:  '"rabbbit"\n"rabbit"'
 *
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE"
 * 的一个子序列，而 "AEC" 不是）
 * 
 * 示例 1:
 * 
 * 输入: S = "rabbbit", T = "rabbit"
 * 输出: 3
 * 解释:
 * 
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * 
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 
 * 
 * 示例 2:
 * 
 * 输入: S = "babgbag", T = "bag"
 * 输出: 5
 * 解释:
 * 
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
 * (上箭头符号 ^ 表示选取的字母)
 * 
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ⁠ ^  ^^
 * babgbag
 * ⁠   ^^^
 * https://blog.csdn.net/qq_17550379/article/details/84098044
 */
class Solution {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len2+1][len1+1];
        for (int i = 1; i <= len2; ++i){
            dp[i][0] = 0;
        }
        for (int i = 0; i <= len1; ++i){
            dp[0][i] = 1;
        }
        for (int i = 1; i <= len2; ++i){
            for (int j = i; j <= len1; ++j){
                if (s.charAt(j - 1) == t.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len2][len1];
    }
}