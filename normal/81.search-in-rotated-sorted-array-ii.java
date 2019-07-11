package lalgorithm.normal;

/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.49%)
 * Total Accepted:    158.5K
 * Total Submissions: 487.5K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        return solution2(nums, target);
    }

    public boolean solution2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[right]){
                left++;
            }else if (nums[left] < nums[right]){
                if (nums[mid] > target){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                //左边是递增的
                if (nums[mid] > nums[right]){
                    if (nums[left] <= target && target < nums[mid]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else {
                    if (nums[mid] < target && target <= nums[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
