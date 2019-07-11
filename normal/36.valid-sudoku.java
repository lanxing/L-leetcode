package lalgorithm.normal;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (41.53%)
 * Total Accepted:    212.7K
 * Total Submissions: 510.4K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * 
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 * 
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being 
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 * 
 * 
 * Note:
 * 
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 * 
 * 
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return valid(board, 0, 0);
    }

    public boolean valid(char[][] board, int m, int n){
        if (n >= 9){
            return valid(board, m + 1, 0);
        }
        if (m == 9){
            return true;
        }
        if (board[m][n] == '.'){
            for (char c = '1'; c <= '9'; ++c){
                board[m][n] = c;
                if (check(board, m, n)){
                    //特别重要，不能直接使用return valid(board, m, n + 1)
                    //因为这样的话就无法回溯了
                    if (valid(board, m, n + 1)){
                        return true;
                    }
                }
                //回溯，将值置为原值
                board[m][n] = '.';
            }
        }else {
            return valid(board, m, n + 1);
        }
        return false;
    }


    private boolean check(char[][] board, int m, int n){

        //检查行
        for (int i = 0; i < 9; ++i){
            if (i != n && board[m][i] == board[m][n]){
                return false;
            }
        }
        //检查列
        for (int j = 0; j < 9; ++j){
            if (j != m && board[j][n] == board[m][n]){
                return false;
            }
        }

        //检查3X3
        int row = m / 3 * 3;
        int col = n / 3 * 3;
        for (int i = row; i < row + 3; ++i){
            for (int j = col; j < col + 3; ++j){
                if (i != m && j != n && board[i][j] == board[m][n]){
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        char[][] test = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};

        System.out.println(new Solution().isValidSudoku(test));
    }
}
