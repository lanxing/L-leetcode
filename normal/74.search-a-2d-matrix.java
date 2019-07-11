package lalgorithm.normal;

/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (34.65%)
 * Total Accepted:    207.3K
 * Total Submissions: 597.7K
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the
 * previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * matrix = [
 * ⁠ [1,   3,  5,  7],
 * ⁠ [10, 11, 16, 20],
 * ⁠ [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int lastIndex = -1;
        for (int i = 0; i < matrix.length; ++i){
            if (matrix[i][0] <= target){
                lastIndex = i;
            }else {
                break;
            }
        }
        if (lastIndex == -1){
            return false;
        }
        return bsearch(matrix[lastIndex], target, 0, matrix[lastIndex].length - 1);
    }

    private boolean bsearch(int[] nums, int target, int start, int end){
        if (start > end){
            return false;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target){
            return true;
        }else if (nums[mid] > target){
            return bsearch(nums, target, start, mid - 1);
        }else {
            return bsearch(nums, target, mid + 1, end);
        }
    }
}
