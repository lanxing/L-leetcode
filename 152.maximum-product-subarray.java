/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (32.53%)
 * Total Accepted:    11.1K
 * Total Submissions: 32.4K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * https://blog.csdn.net/guoziqing506/article/details/51746077
 */
class Solution {
    public int maxProduct(int[] nums) {
        int maxEnd = 1;
        int minEnd = 1;
        int result = Integer.MIN_VALUE;
        for (int num : nums){
            int t1 = num * maxEnd;
            int t2 = num * minEnd;
            maxEnd = Math.max(Math.max(t1, t2), num);
            minEnd = Math.min(Math.min(t1, t2), num);
            result = Math.max(result, maxEnd);
        }
        return result;
    }
}
