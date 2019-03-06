import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (30.28%)
 * Total Accepted:    253.1K
 * Total Submissions: 832.4K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }

        char indexChar = word.charAt(0);
        for (int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++j){
                if (board[i][j] == indexChar){
                    if (word.length() == 1){
                        return true;
                    }
                    if (backtracing(board, i, j, 0, word, new HashSet<>())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 1:向上，2:向右，3：向下，4：向左
     * @param board
     * @param indexI
     * @param indexJ
     * @param index
     * @param word
     * @param tracedSet
     * @return
     */
    public boolean backtracing(char[][] board, int indexI, int indexJ, int index, String word, Set<Integer> tracedSet){
        int m = board.length;
        int n = board[0].length;
        if (index >= word.length()){
            return true;
        }
        if (indexI >= m || indexJ >= n || indexI < 0 || indexJ < 0){
            return false;
        }
        int pos = indexI * m + indexJ;
        if (tracedSet.contains(pos)){
            return false;
        }
        if (board[indexI][indexJ] != word.charAt(index)){
            return false;
        }
        tracedSet.add(pos);
        for (int i = 1; i <= 4; ++i){
            if (i == 1 && backtracing(board, indexI - 1, indexJ, index + 1, word, tracedSet)){
                return true;
            }else if (i == 2 && backtracing(board, indexI, indexJ + 1, index + 1, word, tracedSet)){
                return true;
            }else if (i == 3 && backtracing(board, indexI + 1, indexJ, index + 1, word, tracedSet)){
                return true;
            }else if (backtracing(board, indexI, indexJ - 1, index + 1, word, tracedSet)){
                return true;
            }
        }
        return false;
    }
}
