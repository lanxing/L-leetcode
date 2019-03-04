import java.util.Arrays;

/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.61%)
 * Total Accepted:    354.2K
 * Total Submissions: 870.7K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int flag = 1;
        int tmp;
        for (int i = len - 1; i >= 0; --i){
            tmp = digits[i] + flag;
            digits[i] = tmp % 10;
            flag= tmp / 10;
            if (flag == 0){
                return digits;
            }
        }
        if (flag == 1){
            int[] result = new int[len + 1];
            result[0] = 1;
            for (int i = 1; i <=len; ++i){
                result[i] = 0;
            }
            return result;
        }
        return digits;
    }
}
