/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (19.92%)
 * Total Accepted:    6.1K
 * Total Submissions: 30.6K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */
class Solution {
    public int numDecodings(String s) {
        if ("0".equals(s)){
            return 0;
        }
        return dynamic(s);
    }

    public int dynamic(String s){
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 0; i < s.length(); ++i){
            int first = 0;
            int second = 0;
            if (s.charAt(i) > '0' && s.charAt(i) <= '9'){
                if (i > 0){
                    first = dp[i - 1];
                }else {
                    first = 1;
                }
            }
            if (i > 0){
                Integer two = Integer.valueOf(s.substring(i - 1, i + 1));
                if (two >= 10 && two <= 26){
                    if (i > 1){
                        second = dp[i - 2];
                    }else {
                        second = 1;
                    }
                }
            }
            dp[i] = first + second;
        }
        return dp[s.length() - 1];
    }
}
