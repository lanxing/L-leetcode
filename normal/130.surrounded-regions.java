package lalgorithm.normal;

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (34.42%)
 * Total Accepted:    5.2K
 * Total Submissions: 14.5K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * 运行你的函数后，矩阵变为：
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 使用回溯法和dp，先找到'O'的连续区域，然后再进行筛选
 * 
 */
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0){
            return;
        }
        int n = board[0].length;

        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < n; ++i){
            backTracing(board, dp, 0, i);
        }
        for (int i = 0; i < m; ++i){
            backTracing(board, dp, i, n - 1);
        }
        for (int i = 0; i < n; ++i){
            backTracing(board, dp, m - 1, i);
        }
        for (int i = 0; i < m; ++i){
            backTracing(board, dp, i, 0);
        }

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (board[i][j] == 'O' && !dp[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void backTracing(char[][] board, boolean[][] dp, int indexI, int indexJ){
        int m = board.length;
        int n = board[0].length;

        if (board[indexI][indexJ] == 'O' && !dp[indexI][indexJ]){
            dp[indexI][indexJ] = true;

            if (indexI - 1 >= 0){
                backTracing(board, dp, indexI - 1, indexJ);
            }
            if (indexJ + 1 < n){
                backTracing(board, dp, indexI, indexJ + 1);
            }
            if (indexI + 1 < m){
                backTracing(board, dp, indexI + 1, indexJ);
            }
            if (indexJ - 1 >= 0){
                backTracing(board, dp, indexI, indexJ - 1);
            }

        }
    }
}
