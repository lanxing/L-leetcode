package lalgorithm.normal;

import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (26.09%)
 * Total Accepted:    738.7K
 * Total Submissions: 2.8M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * ⁠            Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 * 
 * 
 * 
 * 
 * 使用双指针和集合即可
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        if (s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int first = 0;
        int second = 1;
        Set<Character> cset = new HashSet<>();
        cset.add(s.charAt(first));
        int maxlen = 0;
        while (second < s.length() && first < s.length()){
            if (cset.contains(s.charAt(second))){
                maxlen = Math.max(maxlen, second - first);
                int i = first;
                while (s.charAt(i) != s.charAt(second)){
                    cset.remove(s.charAt(i));
                    ++i;
                }
                first = i + 1;
            }
            cset.add(s.charAt(second));
            ++second;
        }
        maxlen = Math.max(maxlen, second - first);

        return maxlen;
    }
}
