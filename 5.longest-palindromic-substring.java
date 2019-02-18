import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.33%)
 * Total Accepted:    464.9K
 * Total Submissions: 1.8M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 需要考虑奇数和偶数之分
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1){
            return s;
        }
        int maxLen = 1;
        String maxStr = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length() && (2 * (s.length() - i) >= maxLen); ++i){
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            int tmpLen = right - left - 1;
            if (tmpLen > maxLen){
                maxLen = tmpLen;
                maxStr = s.substring(left + 1, right);
            }
        }

        for (int i = 1; i < s.length() && (2 * (s.length() - i) >= maxLen); ++i){
            int left = i - 1;
            int right = i;
            while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            int tmpLen = right - left - 1;
            if (tmpLen > maxLen){
                maxLen = tmpLen;
                maxStr = s.substring(left + 1, right);
            }
        }
        return maxStr;
    }
}
