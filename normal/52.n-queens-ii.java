package lalgorithm.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (50.53%)
 * Total Accepted:    92.6K
 * Total Submissions: 182.8K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
class Solution {
    public int totalNQueens(int n) {
        List<String> tmp = new ArrayList<>();
        return backTracing(n, tmp, 0, 0);
    }
    public int backTracing(int n, List<String> tmp, int total, int column){

        if (tmp.size() == n) {
            if (isValid(tmp, column)) {
                return total + 1;
            }
            return total;
        }
        if (!isValid(tmp, column)){
            return total;
        }

        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int i = 0; i < n; ++i){
            chars[i] = 'Q';
            tmp.add(new String(chars));
            total = backTracing(n, tmp, total, i);
            chars[i] = '.';
            tmp.remove(tmp.size() - 1);
        }
        return total;
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
