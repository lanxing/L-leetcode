import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (33.39%)
 * Total Accepted:    3.8K
 * Total Submissions: 11.4K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> originCountMap = new HashMap<>();
        Set<Character> sets = new HashSet<>();
        Set<Character> tmpSet = new HashSet<>();
        for (int i  = 0; i < t.length(); ++i){
            char c = t.charAt(i);
            sets.add(c);
            tmpSet.add(c);
            if (originCountMap.containsKey(c)){
                originCountMap.put(c, originCountMap.get(c) + 1);
            }else {
                originCountMap.put(c, 1);
            }
        }

        int left = -1, right = -1;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> tmpMap = new HashMap<>();
        int i = 0;
        while (i < s.length()){
            char c = s.charAt(i);
            if (sets.contains(c)){
                if (left == -1){
                    left = i;
                }
                if (tmpMap.containsKey(c)){
                    tmpMap.put(c, tmpMap.get(c) + 1);
                }else {
                    tmpMap.put(c, 1);
                }
                if (tmpSet.contains(c) && originCountMap.get(c) <= tmpMap.get(c)){
                    tmpSet.remove(c);
                }
            }
            if (tmpSet.size() == 0){
                break;
            }
            ++i;
        }
        String result = "";
        if (tmpSet.size() != 0){
            return result;
        }
        right = i;
        result = s.substring(left, right + 1);
        min = right - left + 1;

        //滑动窗口
        while (left < right){
            char c = s.charAt(left);
            //左边向右边移动，找到第一个在t内的字符
            while (++left < right){
                if (!sets.contains(s.charAt(left))){
                    continue;
                }
                break;
            }

            tmpMap.put(c, tmpMap.get(c) - 1);
            if (tmpMap.get(c) >= originCountMap.get(c)){
                //仍满足条件
                if (min > (right - left + 1) && right < s.length()){
                    min = (right - left + 1);
                    result = s.substring(left, right + 1);
                }
                continue;
            }
            while (right < s.length() && ++right < s.length()){
                char rc = s.charAt(right);
                if (!sets.contains(rc)){
                    continue;
                }
                if (rc == c){
                    tmpMap.put(c, tmpMap.get(c) + 1);
                    if (min > (right - left + 1)){
                        min = (right - left + 1);
                        result = s.substring(left, right + 1);
                    }
                    break;
                }else {
                    tmpMap.put(rc, tmpMap.get(rc) + 1);
                }
            }
        }
        if (min != Integer.MAX_VALUE){
            return result;
        }
        return "";
    }
}
