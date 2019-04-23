import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.49%)
 * Total Accepted:    112.3K
 * Total Submissions: 385.3K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }
        int first = 0;
        int second = first + 1;
        Set<Character> usedSet = new HashSet<>(s.length());
        usedSet.add(s.charAt(0));
        int maxLen = 0;
        while (first < s.length() && second < s.length()){
            char c = s.charAt(second);
            if (!usedSet.contains(c)){
                second++;
                usedSet.add(c);
                continue;
            }
            maxLen = Math.max(maxLen, second - first);
            while (s.charAt(first) != c){
                usedSet.remove(s.charAt(first));
                first++;
            }
            usedSet.remove(c);
            first++;
        }

        return Math.max(maxLen, second - first);
    }
}
