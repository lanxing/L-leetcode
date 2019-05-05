import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode-cn.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (25.61%)
 * Total Accepted:    10.1K
 * Total Submissions: 37.6K
 * Testcase Example:  '"(()"'
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int start = 0;
        for(int index = 0; index < s.length(); ++index){
            if (s.charAt(index) == '('){
                stack.push(index);
            }else {
                if (stack.isEmpty()){
                    start = index + 1;
                    continue;
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        max = Math.max(max, index - start + 1);
                    }else {
                        max = Math.max(max, index - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
