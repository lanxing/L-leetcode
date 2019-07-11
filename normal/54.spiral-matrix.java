package lalgorithm.normal;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (29.52%)
 * Total Accepted:    209.4K
 * Total Submissions: 707.9K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0){
            return result;
        }
        int columns = matrix[0].length;
        if (columns == 0){
            return result;
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
                result.add(matrix[pos1][j]);
                flag = true;
            }
            if (pos1 + 1 > pos3){
                break;
            }
            for (j = pos1 + 1; j <= pos3; ++j){
                result.add(matrix[j][pos2]);
                flag = true;
            }
            if (pos2 - 1 < pos1){
                break;
            }
            for (j = pos2 - 1; j >= pos1; --j){
                result.add(matrix[pos3][j]);
                flag = true;
            }
            if (pos3 - 1 < pos1 + 1){
                break;
            }
            for (j = pos3 - 1; j >= pos1 + 1; --j){
                result.add(matrix[j][pos4]);
                flag = true;
            }

            ++i;
        }
        return result;
    }
}
