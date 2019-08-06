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
        int len = s.length();
        if (len <= 1){
            return len;
        }
        int first = 0, second = first;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(first), first);
        while (second < len){
            second++;
            while (second < len){
                if (map.containsKey(s.charAt(second))){
                    int end = map.get(s.charAt(second));
                    for (int i = first; i <= end; ++i){
                        map.remove(s.charAt(i));
                    }
                    map.put(s.charAt(second), second);
                    max = Math.max(max, second - first);
                    first = map.get(s.charAt(second)) + 1;
                    break;
                }
                map.put(s.charAt(second), second);
                second++;
            }
        }
        return max;
    }
}
