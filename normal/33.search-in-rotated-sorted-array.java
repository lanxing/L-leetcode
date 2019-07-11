package lalgorithm.normal;

/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.57%)
 * Total Accepted:    365.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        return solution2(nums, target);
    }

    public int solution2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
//            在递增数组内
            if (nums[left] < nums[right]){
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
        return -1;
    }

    public int searchB(int[] nums, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            return mid;
        }
        //正常递增
        if (nums[left] <= nums[right]){
            if (nums[mid] < target){
                return searchB(nums, target, mid + 1, right);
            }else {
                return searchB(nums, target, left, mid - 1);
            }
        }else {
            return Math.max(searchB(nums, target, mid + 1, right), searchB(nums, target, left, mid - 1));
        }
    }
}
