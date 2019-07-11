package lalgorithm.normal;

import java.util.*;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.06%)
 * Total Accepted:    339.5K
 * Total Submissions: 846.5K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    private static Map<Character, List<Character>> digitalMap = new HashMap<>();

    static{
        digitalMap.put('2', Arrays.asList('a', 'b', 'c'));
        digitalMap.put('3', Arrays.asList('d', 'e', 'f'));
        digitalMap.put('4', Arrays.asList('g', 'h', 'i'));
        digitalMap.put('5', Arrays.asList('j', 'k', 'l'));
        digitalMap.put('6', Arrays.asList('m', 'n', 'o'));
        digitalMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitalMap.put('8', Arrays.asList('t', 'u', 'v'));
        digitalMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[] nums = new char[digits.length()];
        for (int i = 0; i < digits.length(); ++i){
            result = combinations(result, digits.charAt(i));
        }
        return result;
    }

    public List<String> combinations(List<String> lastList, Character digit){
        if (digit == '0'){
            return lastList;
        }
        List<String> result = new ArrayList<>();
        if (lastList.size() == 0){
            digitalMap.get(digit).forEach(e -> result.add(String.valueOf(e)));
        }else {
            for (String s : lastList){
                for (Character charT : digitalMap.get(digit)){
                    result.add(s + charT);
                }
            }
        }
        return result;
    }
}
