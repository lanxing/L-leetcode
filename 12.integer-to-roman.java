import java.util.HashMap;

/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 *
 * https://leetcode.com/problems/integer-to-roman/description/
 *
 * algorithms
 * Medium (49.52%)
 * Total Accepted:    199.8K
 * Total Submissions: 403.2K
 * Testcase Example:  '3'
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
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * Example 1:
 * 
 * 
 * Input: 3
 * Output: "III"
 * 
 * Example 2:
 * 
 * 
 * Input: 4
 * Output: "IV"
 * 
 * Example 3:
 * 
 * 
 * Input: 9
 * Output: "IX"
 * 
 * Example 4:
 * 
 * 
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * 比如1286；
 * 1. 首先将数字转化为个 十 百 千 1000 + 200 + 80 + 6
 * 2. 将每个数和对应的 4*threhold进行比较，小于的话就是直接拼接，大于的话就和50拼接
 *
 */
class Solution {
    private static HashMap<Integer, String> romanMap;
    static {
        romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
    }
    private String joinStr(int times, String str){
        String result = "";
        for (int i = 0; i < times; ++i){
            result += str;
        }
        return result;
    }
    /**
     * tran都为1、10、100、1000的倍数
     * @param tran
     * @return
     */
    private String tranRoman(int tran){
        if (romanMap.containsKey(tran)){
            return romanMap.get(tran);
        }
        if (tran == 0){
            return "";
        }
        int threslod;
        if (tran / 1000 > 0){
            threslod = 1000;
        }else if (tran / 100 > 0){
            threslod = 100;
        }else if (tran / 10 > 0){
            threslod = 10;
        }else {
            threslod = 1;
        }
        int low = 4 * threslod;

        if (tran < low){
            return joinStr(tran / threslod, romanMap.get(threslod));
        }else {
            return romanMap.get(5 * threslod) + joinStr((tran - 5 * threslod) / threslod, romanMap.get(threslod));
        }
    }
    public String intToRoman(int num) {
        int divide = 1;
        int tmp = num;
        int tran;
        String str = "";
        while (tmp != 0){
            divide = divide * 10;
            tran = tmp % divide;
            str = tranRoman(tran) + str;
            tmp = tmp - tran;
        }
        return str;
    }
}
