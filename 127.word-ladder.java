import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (31.60%)
 * Total Accepted:    5.9K
 * Total Submissions: 17.1K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        int total = 0;
        String tmp = beginWord;
        boolean hasNeighber = false;
        while (true){
            hasNeighber = false;
            for (String str : wordSet){
                if (isNeighbor(tmp, str)){
                    hasNeighber = true;
                    tmp = str;
                    total++;
                    wordSet.remove(str);
                    break;
                }
            }
            if (!hasNeighber){
                break;
            }
            if (isNeighbor(tmp, endWord)){
                total++;
                break;
            }
        }
        return total == 0 ? 0 : total+1;
    }

    private boolean isNeighbor(String first, String second){
        int total = 0;
        for (int i = 0; i < first.length(); ++i){
            if (first.charAt(i) != second.charAt(i)){
                total++;
                if (total >= 2){
                    return false;
                }
            }
        }
        return total == 1;
    }
}
