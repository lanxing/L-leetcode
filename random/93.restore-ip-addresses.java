import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (42.73%)
 * Total Accepted:    7.3K
 * Total Submissions: 16.9K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backTracing(result, new ArrayList<>(), 0, s);
        return result;
    }

    private void backTracing(List<String> result, List<String> tmp, int index, String s){
        if (index > s.length()){
            return;
        }
        if (index == s.length() && tmp.size() == 4){
            result.add(tmp.get(0) + "." + tmp.get(1) + "." + tmp.get(2) + "." + tmp.get(3));
            return;
        }
        for (int i = 0; i < 3; ++i){
            if (index + i >= s.length()){
                break;
            }
            String ipStr = s.substring(index, index + i + 1);
            if (ipStr.charAt(0) == '0' && i > 0){
                continue;
            }
            Integer ipInt = Integer.valueOf(ipStr);
            if (ipInt <= 255){
                tmp.add(String.valueOf(ipInt));
                backTracing(result, tmp, index + i + 1, s);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
