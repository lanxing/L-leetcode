package lalgorithm.normal;

/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (27.48%)
 * Total Accepted:    288.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 指数型增长
 */
class Solution {
    public double myPow(double x, int n) {
        if (x == 1){
            return x;
        }
        boolean flag = n < 0;
        long tmpN = Math.abs((long)n);
        double tmp = powA(x, tmpN, flag);
        if (tmp == 0){
            return 0;
        }
        if (flag){
            return 1 / tmp;
        }
        return tmp;
    }

    public double powA(double x, long n, boolean flag){
        if (n == 0){
            return 1;
        }
        long sum = 1;
        long tmpSum;
        double tmp = x;
        while ((tmpSum = sum * 2) < n){
            sum = tmpSum;
            tmp = tmp * tmp;
            if (tmp == 0){
                return tmp;
            }
            if (flag && (1 / tmp) == 0){
                return 0;
            }
        }
        if (n > sum){
            return tmp * powA(x, n - sum, flag);
        }
        return tmp;
    }
}
