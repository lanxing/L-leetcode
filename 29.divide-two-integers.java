/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.00%)
 * Total Accepted:    177.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
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

        long result = ldivide(ldividend, ldivisor);
        if (result > Integer.MAX_VALUE){
            return sameFlag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (sameFlag){
            return (int) result;
        }else {
            return (int) -result;
        }
    }
    private long ldivide(long ldividend, long ldivisor){
        if (ldividend < ldivisor){
            return 0;
        }
        long sum = ldivisor;
        int result = 1;
        /**
         * ldivisor * 2, *4, *8 ... 2^n
         * while(sum * 2 < ldividend){
         *      sum = sum * 2;
         *      result = result * 2;
         * }
         */
        while ((sum + sum) < ldividend){
            sum += sum;
            result += result;
        }
        return result + ldivide(ldividend - sum, ldivisor);
    }
}
