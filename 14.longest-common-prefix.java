/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (32.89%)
 * Total Accepted:    400.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String tmp = strs[0];
        for (int i = 1; i < strs.length; ++i){
            tmp = longestPrefix(tmp, strs[i]);
            if (tmp.length() == 0){
                return tmp;
            }
        }
        return tmp;
    }

    private String longestPrefix(String first, String second){
        if (first == null || second == null || first.length() == 0 || second.length() == 0){
            return "";
        }
        int firstLen = first.length();
        int secondLen = second.length();
        int index = 0;
        while (index < firstLen && index < secondLen){
            if (first.charAt(index) == second.charAt(index)){
                ++index;
                continue;
            }
            break;
        }
        return first.substring(0, index);
    }
}
