/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (44.38%)
 * Total Accepted:    24.1K
 * Total Submissions: 51.9K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */
class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n == 1){
            return true;
        }
        if (n < 0){
            return false;
        }
        while (n != 0){
            if ((n & 1) == 1){
                break;
            }
            n = n >>> 1;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n <= 0){
            return false;
        }
        while (n % 2 != 1){
            n /= 2;
        }
        if (n == 1){
            return true;
        }
        return false;
    }
}
