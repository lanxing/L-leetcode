import java.util.*;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (44.53%)
 * Total Accepted:    295.2K
 * Total Submissions: 661.3K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            String tmp = sortStr(str);
            List<String> tmpList;
            if (map.containsKey(tmp)){
                tmpList = map.get(tmp);
            }else {
                tmpList = new ArrayList<>();
                map.put(tmp, tmpList);
            }
            tmpList.add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String sortStr(String str){
        char[] strA = str.toCharArray();
        Arrays.sort(strA);
        return String.valueOf(strA);
    }
}
