/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (41.01%)
 * Total Accepted:    29.5K
 * Total Submissions: 70.3K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * 
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1){
            return s;
        }
        char[] result = new char[len];
        int tip = numRows + numRows - 2;
        int firstTip, seondTip, index, newIndex = 0, tmpIndex;
        for (int i = 0; i < numRows; ++i){
            firstTip = tip - i * 2;
            seondTip = i * 2;
            index = i;
            tmpIndex = 0;
            while (index < len){
                result[newIndex++] = s.charAt(index);
                if (seondTip == 0){
                    index += firstTip;
                    continue;
                }
                if (firstTip == 0){
                    index += seondTip;
                    continue;
                }
                if (tmpIndex % 2 == 0 ){
                    index += firstTip;
                }else{
                    index += seondTip;
                }
                tmpIndex++;
            }
        }
        return String.valueOf(result);
    }
}
