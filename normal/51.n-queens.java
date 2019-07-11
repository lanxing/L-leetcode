package lalgorithm.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (37.49%)
 * Total Accepted:    128.6K
 * Total Submissions: 342.3K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        backTracing(n, tmp, result, 0);
        return result;
    }

    public void backTracing(int n, List<String> tmp, List<List<String>> result, int column){

        if (tmp.size() == n) {
            if (isValid(tmp, column)) {
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
            backTracing(n, tmp, result, i);
            chars[i] = '.';
            tmp.remove(tmp.size() - 1);
        }
    }

    public boolean isValid(List<String> queneList, int column){
        int row = queneList.size() - 1;
        for (int i = 0; i < queneList.size() - 1; ++i){
            String str = queneList.get(i);
            int index = str.indexOf('Q');
            if (index != - 1 && index == column || (Math.abs(column - index) == Math.abs(row - i))){
                return false;
            }
        }
        return true;
    }
}
