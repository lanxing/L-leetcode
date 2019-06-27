/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 *
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/
 *
 * algorithms
 * Easy (37.25%)
 * Total Accepted:    13.5K
 * Total Submissions: 34.9K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 
 * 示例 1:
 * 
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * 
 */
class Solution {
    /**
     * 5! = 5 * 2 * 2 * 3 * 2 * 1
     * 只需要找到里面有几个5就行
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {

        int total = 0;
        while (n > 0){
            total += (n / 5);
            n = n / 5;
        }

        return total;
    }
}
