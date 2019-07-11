package lalgorithm.normal;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (20.52%)
 * Total Accepted:    11.1K
 * Total Submissions: 42.8K
 * Testcase Example:  '"the sky is blue"'
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 
 * 
 * 示例 2：
 * 
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 
 * 
 * 示例 3：
 * 
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 * 
 */
class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        int len = strings.length;
        if (len == 0){
            return "";
        }
        String str;
        for (int i = len - 1; i >= 1; --i){
            str = strings[i].trim();
            if (str.equals("")){
                continue;
            }
            buffer.append(str).append(" ");
        }
        str = strings[0].trim();
        if (!str.equals("")) {
            buffer.append(strings[0]);
        }else if (buffer.length() > 0){
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if (buffer.length() == 0){
            return "";
        }
        return buffer.toString();
    }
}
