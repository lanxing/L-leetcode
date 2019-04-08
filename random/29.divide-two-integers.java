/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (17.56%)
 * Total Accepted:    10.3K
 * Total Submissions: 57.8K
 * Testcase Example:  '10\n3'
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 
 * 说明:
 * 
 * 
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        boolean sameFlag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sameFlag = false;
        }

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldivisor == 0){
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (ldividend < ldivisor){
            return 0;
        }

        long result = dividel(ldividend, ldivisor);
        if (result > Integer.MAX_VALUE){
            return sameFlag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (sameFlag){
            return (int) result;
        }else {
            return (int) -result;
        }
    }

    private long dividel(long dividend, long divisor){
        if (dividend < divisor){
            return 0;
        }
        long sum = divisor;
        long result = 1;
        while ((sum + sum) < dividend){
            result += result;
            sum += sum;
        }
        return result + dividel(dividend - sum, divisor);
    }
}
