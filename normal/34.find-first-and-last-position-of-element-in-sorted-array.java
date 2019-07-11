package lalgorithm.normal;

/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (32.84%)
 * Total Accepted:    264.3K
 * Total Submissions: 803.3K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = bsearchL(nums, target, 0, nums.length - 1);
        int right = bsearchR(nums, target, 0, nums.length - 1);
        return new int[]{left, right};
    }

    private int bsearchL(int[] nums, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            if (mid == 0){
                return mid;
            }
            if (nums[mid] != nums[mid - 1]){
                return mid;
            }
            return bsearchL(nums, target, left, mid - 1);
        }
        if (nums[mid] < target){
            return bsearchL(nums, target, mid + 1, right);
        }else {
            return bsearchL(nums, target, left, mid - 1);
        }
    }
    private int bsearchR(int[] nums, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            if (mid == nums.length - 1){
                return mid;
            }
            if (nums[mid] != nums[mid + 1]){
                return mid;
            }
            return bsearchR(nums, target, mid + 1, right);
        }
        if (nums[mid] < target){
            return bsearchR(nums, target, mid + 1, right);
        }else {
            return bsearchR(nums, target, left, mid - 1);
        }
    }
}
