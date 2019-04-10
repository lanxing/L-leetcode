import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (59.52%)
 * Total Accepted:    6.1K
 * Total Submissions: 10.1K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backTracing(n, result, new ArrayList<>(), 0);
        return result;
    }

    private void backTracing(int n, List<List<String>> result, List<String> tmp, int column){
        if (tmp.size() == n){
            if (isValid(tmp, column)){
                result.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (!isValid(tmp, column)){
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int i = 0; i < n; ++i){
            chars[i] = 'Q';
            tmp.add(new String(chars));
            backTracing(n, result, tmp, i);
            tmp.remove(tmp.size() - 1);
            chars[i] = '.';
        }
    }

    private boolean isValid(List<String> result, int column){
        for (int i = 0; i < result.size() - 1; ++i){
            int index = result.get(i).indexOf('Q');
            if (index != -1 && index == column || Math.abs(result.size() - i - 1) == Math.abs(column - index)){
                return false;
            }
        }
        return true;
    }
}
