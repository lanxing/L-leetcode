/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 *
 * https://leetcode-cn.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (20.89%)
 * Total Accepted:    3.8K
 * Total Submissions: 18.2K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 
 * 
 * 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null){
            return true;
        }
        if (s.length() == 0){
            if (p.length() == 0){
                return true;
            }
            if (p.length() == 1 && (p.charAt(0) == '*')){
                return true;
            }
            return false;
        }
        if (p.length() == 0){
            return false;
        }
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); ++i){
            if (p.charAt(i - 1) == '*'){
                dp[i][0] = dp[i - 1][0];
            }else {
                dp[i][0] = false;
            }
        }
        for (int i = 1; i <= s.length(); ++i){
            dp[0][i] = false;
        }
        for (int i = 1; i <= p.length(); ++i){
            char cp = p.charAt(i - 1);
            for (int j = 1; j <= s.length(); ++j){
                if (cp == '*'){
                    dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                }else if (cp == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (cp == s.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
