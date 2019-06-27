import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (63.08%)
 * Total Accepted:    15.5K
 * Total Submissions: 24.1K
 * Testcase Example:  '"A"'
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 
 * 例如，
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: "A"
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: "AB"
 * 输出: 28
 * 
 * 
 * 示例 3:
 * 
 * 输入: "ZY"
 * 输出: 701
 * 
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * 
 */
class Solution {
    private static Map<Character, Integer> map = new HashMap<>(40);
    static {
        for (int i = 1; i <= 26; ++i){
            map.put((char) ('A' + i - 1), i);
        }
    }
    public int titleToNumber(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            total = total * 26 + map.get(c);
        }
        return total;
    }
}
