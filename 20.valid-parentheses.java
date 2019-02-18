import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.73%)
 * Total Accepted:    507.5K
 * Total Submissions: 1.4M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    private static Map<Character, Character> cMap = new HashMap<>(3);
    static {
        cMap.put(')', '(');
        cMap.put(']', '[');
        cMap.put('}', '{');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int len = s.length();
        while (index < len){
            Character tmp = s.charAt(index);
            if (cMap.keySet().contains(tmp)){
                if (stack.isEmpty() || (cMap.get(tmp) != stack.lastElement())){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(s.charAt(index));
            }
            index++;
        }
        return stack.isEmpty();
    }
}
