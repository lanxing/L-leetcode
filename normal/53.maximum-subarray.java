package lalgorithm.normal;

/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (42.68%)
 * Total Accepted:    464.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        int sum = 0;
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; ++i){
            while (i < nums.length){
                sum += nums[i];
                maxSum = Math.max(maxSum, sum);
                if (sum <= 0){
                    sum = 0;
                    break;
                }
                ++i;
            }
        }

        return maxSum;
    }
}
