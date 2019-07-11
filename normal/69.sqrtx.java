package lalgorithm.normal;

/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (30.57%)
 * Total Accepted:    331.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '4'
 *
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * Example 1:
 * 
 * 
 * Input: 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
 * the decimal part is truncated, 2 is returned.
 * 
 * 
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }
        return squrt(x);
    }

    public int squrt(int x){
        long start = 0;
        long end = x;
        while (start < end){
            long mid = (start + end) / 2;
            long tmp = mid * mid;
            if (tmp <= x && (mid + 1) * (mid + 1) > x){
                return (int) mid;
            }
            if (tmp < x){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return (int) start;
    }
}
