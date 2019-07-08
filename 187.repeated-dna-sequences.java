import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 *
 * https://leetcode-cn.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (41.90%)
 * Total Accepted:    3.8K
 * Total Submissions: 8.8K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA
 * 中的重复序列有时会对研究非常有帮助。
 * 
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 * 
 * 示例:
 * 
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        if (len < 10){
            return result;
        }
        Map<String, Integer> map = new HashMap<>(len - 9);
        for (int i = 0; i <= len - 10; ++i){
            String tmp = s.substring(i, i + 10);
            if (map.containsKey(tmp)){
                map.put(tmp, map.get(tmp) + 1);
            }else {
                map.put(tmp, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
