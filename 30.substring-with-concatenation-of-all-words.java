import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 *
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (24.91%)
 * Total Accepted:    4.9K
 * Total Submissions: 19.6K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * 输出：[]
 * 
 * 
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0){
            return result;
        }
        int singleLen = words[0].length();
        int totalLen = words.length * singleLen;
        String[] tmpStrs = new String[words.length];
        Arrays.sort(words);
        for (int i  = 0; i + totalLen <= s.length(); ++i){
            String tmp = s.substring(i, i + totalLen);
            for (int j = 0; j < words.length; ++j){
                tmpStrs[j] = tmp.substring(j * singleLen, (j + 1) * singleLen);
            }
            Arrays.sort(tmpStrs);
            if (isSame(words, tmpStrs)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSame(String[] first, String[] second){
        int len = first.length;
        for (int i = 0; i < len; ++i){
            if (!first[i].equals(second[i])){
                return false;
            }
        }
        return true;
    }
}
