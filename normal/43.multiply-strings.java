package lalgorithm.normal;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (29.88%)
 * Total Accepted:    183K
 * Total Submissions: 611.9K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        List<List<Integer>> multiList = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; --i){
            multiList.add(multiply(num2, num1.charAt(i) - '0', num1.length() - 1 - i));
        }
        return multiAdd(multiList);
    }

    public List<Integer> multiply(String num, int multi, int indexNum){
        int index = 0;
        List<Integer> result = new ArrayList<>();
        while (index++ < indexNum){
            result.add(0);
        }
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; --i){
            int tmp = Math.multiplyExact(num.charAt(i) - '0', multi) + carry;
            result.add(tmp % 10);
            carry = tmp / 10;
        }
        if (carry != 0){
            result.add(carry);
        }
        return result;
    }

    public String multiAdd(List<List<Integer>> multiList){
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        boolean flag = true;
        int index = 0;
        while (flag){
            flag = false;
            int tmp = carry;
            for (List<Integer> tmpList : multiList){
                if (index >= tmpList.size()){
                    continue;
                }
                tmp += tmpList.get(index);
                flag = true;
            }
            if (!flag){
                break;
            }
            builder.append((char) ((tmp % 10) + '0'));
            carry = tmp / 10;
            ++index;
        }
        if (carry != 0){
            builder.append((char)(carry + '0'));
        }
        return builder.reverse().toString();
    }
}
