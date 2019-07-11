package lalgorithm.normal;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (52.75%)
 * Total Accepted:    296.6K
 * Total Submissions: 560.8K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 对于生成括号的规则：
 * 1. 只要"("的数量没有超过n，都可以插入"("。
   2. 而可以插入")"的前提则是当前的"("数量必须要多余当前的")"数量。
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    private void generate(int left, int right, int n, String s, List<String> result){
        if (left == right && left == n){
            result.add(s);
            return;
        }
        if (left < n){
            generate(left + 1, right, n, s + "(", result);
        }
        if (left > right){
            generate(left, right + 1, n, s + ")", result);
        }
//        if (left == right){
//            generate(left + 1, right, n, s + "(", result);
//        }else if (left < n){
//            generate(left + 1, right, n, s + "(", result);
//            generate(left, right + 1, n, s + ")", result);
//        }
    }
}
