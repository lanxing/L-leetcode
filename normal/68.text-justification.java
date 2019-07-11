package lalgorithm.normal;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 *
 * https://leetcode-cn.com/problems/text-justification/description/
 *
 * algorithms
 * Hard (35.50%)
 * Total Accepted:    1.5K
 * Total Submissions: 4.1K
 * Testcase Example:  '["This", "is", "an", "example", "of", "text", "justification."]\n16'
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 说明:
 * 
 * 
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。       
 * ⁠    第二行同样为左对齐，这是因为这行只包含一个单词。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * words =
 * ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * ⁠ "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length){
            StringBuffer buffer = new StringBuffer();
            int len = 0;
            int j = i;
            while (j < words.length){
                if (len + words[j].length() + j - i > maxWidth){
                    break;
                }
                len += words[j].length();
                ++j;
            }
            int wordsCount = j - i;
            int spaceCount = wordsCount - 1;
            int spaceLen = maxWidth - len;
            int eachSpaceCount = 0;
            int outSpaceCount = 0;
            if (spaceCount != 0){
                eachSpaceCount = spaceLen / spaceCount;
                outSpaceCount = spaceLen % spaceCount;
            }
            int spaceIndex = 0;
            if (j >= words.length){
                //最后一行
                for (int k = i; k < j; ++k){
                    buffer.append(words[k]);
                    if (k != j - 1){
                        buffer.append(" ");
                    }
                }
                int num = maxWidth - buffer.toString().length();
                while (num > 0){
                    buffer.append(" ");
                    num--;
                }
            }else {
                for (int k = i; k < j; ++k){
                    if (k == j - 1){
                        buffer.append(words[k]);
                    }else {
                        buffer.append(words[k]);
                        spaceIndex = 0;
                        while (spaceIndex < eachSpaceCount){
                            spaceIndex++;
                            buffer.append(" ");
                        }
                        if (outSpaceCount > 0){
                            buffer.append(" ");
                            outSpaceCount--;
                        }
                    }
                }
                int num = maxWidth - buffer.toString().length();
                while (num > 0){
                    buffer.append(" ");
                    num--;
                }
            }
            i = j;
            result.add(buffer.toString());
        }
        return result;
    }
}
