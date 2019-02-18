/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.07%)
 * Total Accepted:    596K
 * Total Submissions: 2.4M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 主要难点是溢出判断，乘以10以后很有可能溢出
 */
class Solution {
    private static double max = Math.pow(2, 31) - 1;
    private static double min = 0 - Math.pow(2, 31);
    public int reverse(int x) {
        boolean signalFlag = x < 0;
        x = Math.abs(x);
        int result = 0;
        while (x != 0 ){
            int tmp = result;
            result =  tmp * 10 + x % 10;
            //溢出判断
            if (result / 10 != tmp){
                return 0;
            }
            x = x / 10;
        }
        if (signalFlag){
            result = 0 - result;
        }
        return result;
    }
}
