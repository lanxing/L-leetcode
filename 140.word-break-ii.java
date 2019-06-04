import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 *
 * https://leetcode-cn.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (34.79%)
 * Total Accepted:    3.8K
 * Total Submissions: 9.9K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典
 * wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 
 * 说明：
 * 
 * 
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 
 * 
 * 示例 1：
 * 
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * 示例 2：
 * 
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * 
 * 
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        backTracing(s, 0, new ArrayList<>(), result, wordDict);
        return result;
    }

    public void backTracing(String s, int index, List<String> tmp, List<String> result, List<String> wordDict){
        if (index >= s.length()){
            result.add(group(tmp));
            return;
        }
        for (String str : wordDict){
            if (s.indexOf(str, index) == index){
                tmp.add(str);
                index += str.length();
                backTracing(s, index, tmp, result, wordDict);
                index -= str.length();
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private String group(List<String> tmp){
        StringBuffer buffer = new StringBuffer();
        int len = tmp.size();
        for (int i = 0; i < len; ++i) {
            String str = tmp.get(i);
            buffer.append(str);
            if (i != len - 1) {
                buffer.append(" ");
            }
        }

        return buffer.toString();
    }
}
