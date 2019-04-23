/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 *
 * https://leetcode-cn.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (34.90%)
 * Total Accepted:    32.4K
 * Total Submissions: 91.5K
 * Testcase Example:  '4'
 *
 * 实现 int sqrt(int x) 函数。
 * 
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * 示例 1:
 * 
 * 输入: 4
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 
 * 由于返回类型是整数，小数部分将被舍去。
 * 
 * 
 */
class Solution {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }

        long start = 0, end = x;
        long result;
        while (true){
            long mid = (start + end) / 2;
            long tmp = mid * mid;
            if (tmp <= x && (mid + 1) * (mid + 1) > x){
                result = mid;
                break;
            }
            if (tmp > x){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return (int) result;
    }
}
