package lalgorithm.normal;

/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (38.33%)
 * Total Accepted:    36.4K
 * Total Submissions: 92K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        char left, right;
        while (start < end){
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            if (start < end){
                left = s.charAt(start);
                if (Character.isLetter(left)){
                    left = Character.toLowerCase(left);
                }
            }else {
                break;
            }
            while (end > start && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if (end > start){
                right = s.charAt(end);
                if (Character.isLetter(right)){
                    right = Character.toLowerCase(right);
                }
            }else {
                break;
            }
            if (left != right){
                break;
            }

            start++;
            end--;
        }
        return start >= end;
    }
}
