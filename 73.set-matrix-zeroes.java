import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (38.87%)
 * Total Accepted:    191K
 * Total Submissions: 490.3K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 
 * Follow up:
 * 
 * 
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        solution2(matrix);
    }

    private void solution2(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean rowFlag = false;
        boolean columnFlag = false;
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < columns; ++j){
                if (matrix[i][j] == 0){
                    if (i == 0){
                        rowFlag = true;
                    }
                    if (j == 0){
                        columnFlag = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; ++i){
            if (matrix[i][0] == 0){
                for (int j = 1; j < columns; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < columns; ++i){
            if (matrix[0][i] == 0){
                for (int j = 1; j < rows; ++j){
                    matrix[j][i] = 0;
                }
            }
        }
        if (rowFlag){
            for (int i = 0; i < columns; ++i){
                matrix[0][i] = 0;
            }
        }
        if (columnFlag){
            for (int i = 0; i < rows; ++i){
                matrix[i][0] = 0;
            }
        }
    }


    private void solution1(int[][] matrix){
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < columns; ++j){
                if (matrix[i][j] == 0){
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < columns; ++j){
                if (iSet.contains(i)){
                    matrix[i][j] = 0;
                }else if (jSet.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
