/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (31.07%)
 * Total Accepted:    377.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '"hello"\n"ll"'
 *
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Example 1:
 * 
 * 
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * 
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()){
            return 0;
        }
        int len1 = haystack.length();
        int len2 = needle.length();
        int result = -1;
        for (int i = 0; i < len1; ++i){
            int index = i;
            int j = 0;
            while (index < len1 && j < len2){
                if (haystack.charAt(index) == needle.charAt(j)){
                    index++;
                    j++;
                    continue;
                }
                break;
            }
            if (j == len2){
                result = i;
                break;
            }
        }
        return result;
    }
}
