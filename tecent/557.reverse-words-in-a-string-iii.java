/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (63.47%)
 * Total Accepted:    21.5K
 * Total Submissions: 32.3K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 
 * 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 
 */
class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if (len <= 1){
            return s;
        }
        StringBuffer result = new StringBuffer(len);
        for (int i = 0; i < len;){
            StringBuffer tmp = new StringBuffer();
            while (i < len && s.charAt(i) != ' '){
                tmp.append(s.charAt(i));
                ++i;
            }
            if (tmp.length() > 0){
                result.append(tmp.reverse().toString());
            }
            while (i < len && s.charAt(i) == ' '){
                result.append(" ");
                ++i;
            }
        }
        return result.toString();

    }
}
