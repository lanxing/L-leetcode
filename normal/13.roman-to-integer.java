package lalgorithm.normal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 *
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * algorithms
 * Easy (51.35%)
 * Total Accepted:    356.2K
 * Total Submissions: 693.3K
 * Testcase Example:  '"III"'
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making
 * four. The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * 
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: "III"
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: "IV"
 * Output: 4
 * 
 * Example 3:
 * 
 * 
 * Input: "IX"
 * Output: 9
 * 
 * Example 4:
 * 
 * 
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 */
class Solution {

    private static HashMap<String, Integer> romanMap;
    static {
        romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);
    }

    public int romanToInt(String s) {
        List<String> tmpList = new LinkedList<>();
        if (s == null || s.length() == 0){
            return 0;
        }

        int first = 0;
        int len = s.length();
        while (first < len){
            int second = first + 1;
            if (second >= s.length()){
                tmpList.add(s.substring(first, len));
                first++;
                continue;
            }
            //两个相等，说明有多个一样的字母
            if (s.charAt(first) == s.charAt(second)){
                ++second;
                while (second < len && s.charAt(first) == s.charAt(second)){
                    ++second;
                }
                tmpList.add(s.substring(first, second));
                first = second;
                continue;
            }
            //第一个小于第二个，说明类似于4，40，和400一类的
            if (romanMap.get(String.valueOf(s.charAt(first))) < romanMap.get(String.valueOf(s.charAt(second)))){
                tmpList.add(s.substring(first, second + 1));
                first = second + 1;
                continue;
            }
            //最后一种情况，第一个大于第二个
            tmpList.add(String.valueOf(s.charAt(first)));
            first++;
        }
        int result = 0;
        for (String str : tmpList){
            result += tranNum(str);
        }
        return result;
    }

    private int tranNum(String s){
        if (s.length() == 1){
            return romanMap.get(s);
        }else if (s.charAt(0) == s.charAt(1)){
            return s.length() * romanMap.get(String.valueOf(s.charAt(0)));
        }else {
            return romanMap.get(s);
        }
    }
}
