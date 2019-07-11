package lalgorithm.normal;

/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.81%)
 * Total Accepted:    240.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        return solution2(s);
    }

    /**
     * 动态规划，类似于斐波那契数列
     * @param s
     * @return
     */
    private int solution2(String s){
        int len = s.length();
        int first = 1;
        int second = 1;
        for (int i = 0; i < len; ++i){
            char f = s.charAt(i);
            int tmp;
            if (f >= '1' && f <= '9'){
                tmp = second;
            }else {
                tmp = 0;
            }
            if (i > 0){
                int ff = Integer.valueOf(s.substring(i - 1, i + 1));
                if (ff >= 10 && ff <= 26){
                    tmp += first;
                }
            }
            first = second;
            second = tmp;
        }
        return second;
    }

    private int tracing(String s, int index){

        if (index < 0){
            return 0;
        }

        char last = s.charAt(index);
        int first = 0, second = 0;
        if (last >= '1' && last <= '9'){
            if (index == 0){
                first = 1;
            }else {
                first = tracing(s, index - 1);
            }
        }

        if (index >= 1){
            int tmp = Integer.valueOf(s.substring(index - 1, index + 1));
            if (tmp <= 26 && tmp >= 10){
                if (index == 1){
                    second = 1;
                }else {
                    second = tracing(s, index - 2);
                }
            }
        }

        return first + second;
    }
}
