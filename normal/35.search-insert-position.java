package lalgorithm.normal;

/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (40.37%)
 * Total Accepted:    357.7K
 * Total Submissions: 885.5K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 * 
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        return bsearch(nums, target, 0, nums.length - 1);
    }

    public int bsearch(int[] nums, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            return mid;
        }

        if (nums[mid] > target){
            if (mid == 0 || nums[mid - 1] < target){
                return mid;
            }
            return bsearch(nums, target, left, mid - 1);
        }else {
            if (mid == nums.length - 1 || nums[mid + 1] > target){
                return mid + 1;
            }
            return bsearch(nums, target, mid + 1, right);
        }
    }
}
