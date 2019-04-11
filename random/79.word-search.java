import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (36.05%)
 * Total Accepted:    8.4K
 * Total Submissions: 23K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board[0].length;
        int m = board.length;
        List<Integer> used = new ArrayList<>();
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (board[i][j] == word.charAt(0)){
                    used.add(i * n + j);
                    if (backTracing(board, j, i, word, 1, used)){
                        return true;
                    }
                    used.remove(used.size() - 1);
                }
            }
        }
        return false;
    }

    private boolean backTracing(char[][] board, int col, int row, String word, int index, List<Integer> used){
        int n = board[0].length;
        int m = board.length;
        if (index == word.length()){
            return true;
        }
        char c = word.charAt(index);
        for (int i = 0; i < 4; ++i){
            if (i == 0){
                //向上
                if (row - 1 >= 0 && board[row - 1][col] == c && !used.contains(((row - 1) * n + col))){
                    used.add((row - 1) * n + col);
                    boolean tmp = backTracing(board, col, row - 1, word, index + 1, used);
                    if (tmp){
                        return true;
                    }else {
                        used.remove(used.size() - 1);
                    }
                }
            }else if (i == 1){
                //向右
                if (col + 1 < n && board[row][col + 1] == c && !used.contains((row) * n + col + 1)){
                    used.add((row) * n + col + 1);
                    boolean tmp = backTracing(board, col + 1, row , word, index + 1, used);
                    if (tmp){
                        return true;
                    }else {
                        used.remove(used.size() - 1);
                    }
                }
            }else if (i == 2){
                //向下
                if (row + 1 < m && board[row + 1][col] == c && !used.contains((row + 1) * n + col)){
                    used.add((row + 1) * n + col);
                    boolean tmp = backTracing(board, col, row + 1 , word, index + 1, used);
                    if (tmp){
                        return true;
                    }else {
                        used.remove(used.size() - 1);
                    }
                }
            }else {
                //向左
                if (col - 1 >= 0 && board[row][col - 1] == c && !used.contains((row) * n + col - 1)){
                    used.add((row) * n + col - 1);
                    boolean tmp = backTracing(board, col - 1, row , word, index + 1, used);
                    if (tmp){
                        return true;
                    }else {
                        used.remove(used.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
