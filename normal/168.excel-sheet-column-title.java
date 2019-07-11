package lalgorithm.normal;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (30.35%)
 * Total Accepted:    9.2K
 * Total Submissions: 27.7K
 * Testcase Example:  '1'
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 * 例如，
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "A"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 28
 * 输出: "AB"
 * 
 * 
 * 示例 3:
 * 
 * 输入: 701
 * 输出: "ZY"
 * 
 * 
 */
class Solution {
    private static Map<Integer, Character> map = new HashMap<>(40);
    static {
        for (int i = 1; i <= 26; ++i){
            map.put(i, (char) ('A' + i - 1));
        }
    }
    public String convertToTitle(int n) {
        StringBuffer buffer = new StringBuffer();
        while (n > 0){
            int remain = n % 26;
            n = n / 26;
            if (remain == 0){
                buffer.append("Z");
                n--;
            }else {
                buffer.append(map.get(remain));
            }
        }
        return buffer.reverse().toString();
    }
}
