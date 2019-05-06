/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (31.60%)
 * Total Accepted:    15.4K
 * Total Submissions: 47.9K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 
 * 
 * 示例 2:
 * 
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 
 * 
 * 示例 3:
 * 
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 说明:
 * 
 * 
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * 
 * 
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        boolean flag = n < 0;

        if (Double.compare(x, 1) == 0){
            return x;
        }
        if (Double.compare(x, -1) == 0){
            if (n % 2 == 0){
                return -x;
            }
            return x;
        }
        double total = pow(x, Math.abs(n), flag);
        if (Double.compare(total, 0) == 0){
            return total;
        }
        if (flag){
            return 1 / total;
        }
        return total;
    }

    private double pow(double x, int n, boolean flag){
        if (n == 1){
            return x;
        }
        if (n == 0){
            return 1;
        }
        int num = 1;
        double total = x;
        while (num * 2 <= n){
            if (Double.compare(Math.abs(total), 0.00001) <= 0 || (flag && (Double.compare(Math.abs(1 / total), 0.0001)) <= 0)){
                return 0;
            }
            total *= total;
            num *= 2;
        }
        return total * pow(x, n - num, flag);
    }
}
