/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 *
 * https://leetcode.com/problems/rotate-image/description/
 *
 * algorithms
 * Medium (46.61%)
 * Total Accepted:    224.5K
 * Total Submissions: 480.7K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Note:
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * Example 1:
 * 
 * 
 * Given input matrix = 
 * [
 * ⁠ [1,2,3],
 * ⁠ [4,5,6],
 * ⁠ [7,8,9]
 * ],
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [7,4,1],
 * ⁠ [8,5,2],
 * ⁠ [9,6,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Given input matrix =
 * [
 * ⁠ [ 5, 1, 9,11],
 * ⁠ [ 2, 4, 8,10],
 * ⁠ [13, 3, 6, 7],
 * ⁠ [15,14,12,16]
 * ], 
 * 
 * rotate the input matrix in-place such that it becomes:
 * [
 * ⁠ [15,13, 2, 5],
 * ⁠ [14, 3, 4, 1],
 * ⁠ [12, 6, 8, 9],
 * ⁠ [16, 7,10,11]
 * ]
 * 
 * 
 */
class Solution {
    public void rotate(int[][] matrix) {
        columnMidFold(matrix);
        obliqueMidFold(matrix);
    }

    //按照中间列折叠
    public void columnMidFold(int[][] matrix){
        int n = matrix[0].length;
        for (int i = 0; i < n; ++i){
            int[] nums = matrix[i];
            for (int j = 0; j < n / 2; ++j){
                swap(nums, j, n - 1 - j);
            }
        }
    }

    //左斜对角线折叠
    public void obliqueMidFold(int[][] matrix){
        int n = matrix[0].length;
        for (int i = 0; i < n - 1; ++i){
            for (int j = 0; j < n - 1 - i; ++j){
                swap(matrix, i, j, n);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void swap(int[][] matrix, int i,  int j, int n){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][n - i - 1];
        matrix[n - j - 1][n - i - 1] = tmp;
    }
}
