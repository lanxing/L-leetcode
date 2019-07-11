package lalgorithm.normal;

/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.14%)
 * Total Accepted:    246K
 * Total Submissions: 765.4K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int index = 0;
        int count = 0;
        while (index < len){

            while (index < len && s.charAt(index) == ' '){
                ++index;
            }
            if (index == len){
                return count;
            }
            count = 0;
            while (index < len && s.charAt(index) != ' '){
                count++;
                ++index;
            }
            if (index == len){
                return count;
            }
        }
        return count;
    }
}
