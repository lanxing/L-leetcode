package lalgorithm.normal;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (61.66%)
 * Total Accepted:    7.6K
 * Total Submissions: 12.2K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 先生成i-j是回文的dp，然后用回溯法回溯
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null){
            return result;
        }
        boolean[][] dp = buildDp(s);
        backTracing(s, result, new ArrayList<>(), 0, dp);
        return result;
    }

    boolean[][] buildDp(String s){
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        int index = 1;
        while (index < len) {
            for (int i = 0; i < len - index; ++i) {
                for (int j = index; j < len; ++j) {
                    if (i > j){
                        continue;
                    }
                    if ((i + 1 > j - 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                }
            }
            ++index;
        }
        return dp;
    }

    public void backTracing(String s, List<List<String>> result, List<String> tmp, int start, boolean[][] dp){
        if (start >= s.length()){
            result.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < s.length(); ++i){
            if (dp[start][i]){
                tmp.add(s.substring(start, i + 1));
                backTracing(s, result, tmp, i + 1, dp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
