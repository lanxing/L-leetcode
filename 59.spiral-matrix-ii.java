/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (45.18%)
 * Total Accepted:    127.4K
 * Total Submissions: 281.1K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n^2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rows = n;
        if (rows == 0){
            return matrix;
        }
        int columns = n;
        if (columns == 0){
            return matrix;
        }
        int i = 0;
        int j;
        boolean flag = true;
        while (flag){
            flag = false;
            //行起始
            int pos1 = i;
            //列终止
            int pos2 = columns -1 - i;
            //行起始
            int pos3 = rows -1 - i;
            //列终止
            int pos4 = i;

            if (pos1 > pos2){
                break;
            }
            for (j = pos1; j <= pos2; ++j){
                matrix[pos1][j] = num++;
                flag = true;
            }
            if (pos1 + 1 > pos3){
                break;
            }
            for (j = pos1 + 1; j <= pos3; ++j){
                matrix[j][pos2] = num++;
                flag = true;
            }
            if (pos2 - 1 < pos1){
                break;
            }
            for (j = pos2 - 1; j >= pos1; --j){
                matrix[pos3][j] = num++;
                flag = true;
            }
            if (pos3 - 1 < pos1 + 1){
                break;
            }
            for (j = pos3 - 1; j >= pos1 + 1; --j){
                matrix[j][pos4] = num++;
                flag = true;
            }

            ++i;
        }
        return matrix;

    }
}
