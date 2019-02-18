/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (30.39%)
 * Total Accepted:    281.5K
 * Total Submissions: 925.7K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 主要计算出规则即可
 * midRows表示两列直接有数据的数
 * midRows = numRows - 2;
 * base表示每一大列，PAYP，ISHI等
 * interval表示每一个base与下一小列位置的差值，
 * interval = numRows + midRows - i * 2
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int midRows = numRows - 2;
        int len = s.length();
        int index = 0;
        char[] result = new char[len];
        for (int i = 0; i < numRows; ++i){
            boolean flag = true;
            int j = 0;
            int base;
            int interval = numRows + midRows - i * 2;
            if (i == 0){
                interval = 0;
            }
            while (flag){
                base = i + j * (numRows + midRows);
                ++j;
                if (base >= len){
                    flag = false;
                }else {
                    result[index++] = s.charAt(base);
                }
                if (i == 0 || i == numRows - 1){
                    continue;
                }
                if (base + interval >= len){
                    flag = false;
                }else {
                    result[index++] = s.charAt(base + interval);
                }
            }
        }
        return String.valueOf(result);
    }
}
