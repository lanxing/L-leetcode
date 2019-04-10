import java.util.*;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (54.45%)
 * Total Accepted:    13.7K
 * Total Submissions: 25.1K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mps = new HashMap<>();
        for (String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String tmp = new String(chs);
            if (!mps.containsKey(tmp)){
                mps.put(tmp, new ArrayList<>());
            }
            mps.get(tmp).add(str);
        }
        return new ArrayList<>(mps.values());
    }
}
