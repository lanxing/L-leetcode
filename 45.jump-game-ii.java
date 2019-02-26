/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (27.35%)
 * Total Accepted:    153.6K
 * Total Submissions: 560.7K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * ⁠   Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 * 二指针问题，最大覆盖区间。
从左往右扫描，维护一个覆盖区间，每扫过一个元素，就重新计算覆盖区间的边界。比如，开始时区间[start, end], 遍历A数组的过程中，不断计算A[i]+i最大值（即从i坐标开始最大的覆盖坐标），并设置这个最大覆盖坐标为新的end边界。而新的start边界则为原end+1。不断循环，直到end> n.

 */
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        return greedy(nums);
    }

    public int greedy(int[] nums){
        int start = 0;
        int end = 0;
        int count = 0;
        int len = nums.length;
        while (end < len){
            int max = 0;
            count++;
            for (int i = start; i <= end; ++i){
                if (nums[i] + i >= len - 1){
                    return count;
                }
                if (nums[i] + i > max){
                    max = nums[i] + i;
                }
            }
            start = end + 1;
            end = max;
        }
        return count;
    }
}
