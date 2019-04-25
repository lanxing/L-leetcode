import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (37.90%)
 * Total Accepted:    13.4K
 * Total Submissions: 35.2K
 * Testcase Example:  '"2"\n"3"'
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 
 * 说明：
 * 
 * 
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if (num1.equals("1")){
            return num2;
        }
        if (num2.equals("1")){
            return num1;
        }
        List<String> result = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < num2.length(); ++i){
            String tmp = multiply(num1, num2.charAt(num2.length() - i - 1), i);
            maxLen = Math.max(maxLen, tmp.length());
            result.add(tmp);
        }
        return add(result, maxLen);

    }

    private String multiply(String num1, char c, int bitCount){
        if (c == '0'){
            return "0";
        }
        if (num1.equals("0")){
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= bitCount; ++i){
            builder.append('0');
        }
        int m = c - '0';
        if (m == 1){
            builder.append(num1);
            return builder.reverse().toString();
        }
        int flag = 0;
        int tmp;
        int len = num1.length();
        for (int i = len - 1; i >= 0; --i){
            tmp = flag + (m * (num1.charAt(i) - '0'));
            builder.append(tmp % 10);
            flag = tmp / 10;
        }
        if (flag != 0){
            builder.append(flag);
        }
        return builder.reverse().toString();
    }

    private String add(List<String> stringList, int maxLen){
        int flag = 0;
        int tmpR;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < maxLen; ++i){
            tmpR = flag;
            for (String tmp : stringList){
                if (i < tmp.length()){
                    tmpR += (tmp.charAt(tmp.length() - 1 - i) - '0');
                }
            }
            builder.append(tmpR % 10);
            flag = tmpR / 10;
        }
        if (flag != 0){
            builder.append(flag);
        }
        return builder.reverse().toString();
    }
}
