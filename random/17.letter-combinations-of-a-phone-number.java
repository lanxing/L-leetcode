import java.util.*;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (48.01%)
 * Total Accepted:    19.6K
 * Total Submissions: 40.6K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */
class Solution {

    private static Map<Character, List<Character>> digitalMap = new HashMap<>();

    static{
        digitalMap.put('2', Arrays.asList('a', 'b', 'c'));
        digitalMap.put('3', Arrays.asList('d', 'e', 'f'));
        digitalMap.put('4', Arrays.asList('g', 'h', 'i'));
        digitalMap.put('5', Arrays.asList('j', 'k', 'l'));
        digitalMap.put('6', Arrays.asList('m', 'n', 'o'));
        digitalMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitalMap.put('8', Arrays.asList('t', 'u', 'v'));
        digitalMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int len = digits.length();
        for (int i = 0; i < len; ++i){
            char c = digits.charAt(i);
            List<Character> values = digitalMap.get(c);
            result = addChar(result, values);
        }
        return result;
    }

    private List<String> addChar(List<String> last, List<Character> values){
        if (values == null){
            return last;
        }
        List<String> result = new ArrayList<>();
        if (last.size() == 0){
            values.forEach(e -> result.add(String.valueOf(e)));
        }else {
            for (String str : last){
                for (Character c : values){
                    result.add(str + c);
                }
            }
        }
        return result;
    }
}
