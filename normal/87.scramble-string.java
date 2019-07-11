package lalgorithm.normal;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 *
 * https://leetcode-cn.com/problems/scramble-string/description/
 *
 * algorithms
 * Hard (40.49%)
 * Total Accepted:    1.5K
 * Total Submissions: 3.8K
 * Testcase Example:  '"great"\n"rgeat"'
 *
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * 
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 * 
 * ⁠   great
 * ⁠  /    \
 * ⁠ gr    eat
 * ⁠/ \    /  \
 * g   r  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 * 
 * ⁠   rgeat
 * ⁠  /    \
 * ⁠ rg    eat
 * ⁠/ \    /  \
 * r   g  e   at
 * ⁠          / \
 * ⁠         a   t
 * 
 * 
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * 
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
 * 
 * ⁠   rgtae
 * ⁠  /    \
 * ⁠ rg    tae
 * ⁠/ \    /  \
 * r   g  ta  e
 * ⁠      / \
 * ⁠     t   a
 * 
 * 
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * 
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 * http://www.shilei.club/index.php/2018/08/15/article13/
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        s1 = String.valueOf(s1Array);
        s2 = String.valueOf(s2Array);
        if (s1.equals(s2)){
            return true;
        }
        int len = s1.length();
        for (int i = 1; i < len; ++i){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if (isScramble(s11, s21) && isScramble(s12, s22)){
                return true;
            }
            s21 = s2.substring(len - i);
            s22 = s2.substring(0, len - i);
            if (isScramble(s11, s21) && isScramble(s12, s22)){
                return true;
            }
        }
        return false;
    }
}
