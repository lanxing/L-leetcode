/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (50.22%)
 * Total Accepted:    4.3K
 * Total Submissions: 8.5K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */
class Solution {
    public void solveSudoku(char[][] board) {
        valid(board, 0, 0);
    }

    private boolean valid(char[][] board, int m, int n){
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
                    if (valid(board, m, n + 1)){
                        return true;
                    }
                }
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
}
