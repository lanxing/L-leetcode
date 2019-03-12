import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (30.61%)
 * Total Accepted:    131.2K
 * Total Submissions: 426.1K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backTracing(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backTracing(String s, int index, List<Integer> tmp, List<String> result){
        if (index == s.length() && tmp.size() == 4){
            result.add(covertToIp(tmp));
            return;
        }
        if (index == s.length() || tmp.size() == 4){
            return;
        }

        int tmpInt;
        for (int i = 1; i <= 3; ++i){
            if (index + i <= s.length()){
                tmpInt = Integer.valueOf(s.substring(index, index + i));
                if (isValid(tmpInt, i)){
                    tmp.add(tmpInt);
                    backTracing(s, index + i, tmp, result);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private boolean isValid(int num, int bit){
        if (bit == 1){
            return num >= 0 && num <= 9;
        }
        if (bit == 2){
            return num >= 10 && num <= 99;
        }
        if (bit == 3){
            return num >= 100 && num <= 255;
        }
        return true;
    }

    private String covertToIp(List<Integer> tmp){
        return tmp.get(0) + "." + tmp.get(1) + "." + tmp.get(2) + "." + tmp.get(3);
    }
}
