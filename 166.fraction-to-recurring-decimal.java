import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 *
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (22.04%)
 * Total Accepted:    3.2K
 * Total Submissions: 13.3K
 * Testcase Example:  '1\n2'
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 
 * 示例 1:
 * 
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 
 * 
 * 示例 2:
 * 
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 
 * 示例 3:
 * 
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * 
 * 
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        StringBuffer buffer = new StringBuffer();

        Long numeratorL = Long.valueOf(numerator);
        Long denominatorL = Long.valueOf(denominator);
        if ((numeratorL > 0 && denominatorL < 0) || (numeratorL < 0 && denominatorL > 0)){
            buffer.append("-");
        }
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);

        long result = numeratorL / denominatorL;
        long remain = numeratorL % denominatorL;
        buffer.append(result);
        if (remain == 0){
            return buffer.toString();
        }
        buffer.append(".");
        Map<Long, Integer> remainMap = new HashMap<>();
        while (remain != 0){
            if (remainMap.containsKey(remain)){
                buffer.insert(remainMap.get(remain), "(").append(")");
                break;
            }
            buffer.append(remain * 10 / denominatorL);
            remainMap.put(remain, buffer.length() - 1);
            remain = remain * 10 % denominatorL;
        }

        return buffer.toString();
    }
}
