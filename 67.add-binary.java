/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (37.80%)
 * Total Accepted:    276.8K
 * Total Submissions: 729.4K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int len = Math.max(aLen, bLen);
        int first, second, tmp, flag = 0;
        for (int i = aLen - 1, j = bLen - 1;;){
            if (i < 0 && j < 0){
                break;
            }
            if (i < 0){
                first = 0;
            }else {
                first = a.charAt(i) - '0';
                --i;
            }
            if (j < 0){
                second = 0;
            }else {
                second = b.charAt(j) - '0';
                --j;
            }
            tmp = first + second + flag;
            flag = tmp / 2;
            builder.append(tmp - tmp / 2 * 2);
        }
        if (flag > 0){
            builder.append(flag);
        }
        return builder.reverse().toString();
    }
}
