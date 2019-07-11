package lalgorithm.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (29.93%)
 * Total Accepted:    7.4K
 * Total Submissions: 22.9K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */
class Solution {
    public String largestNumber(int[] nums) {

        List<String> tmp = new ArrayList<>();
        int size0 = 0;
        for (int num : nums){
            if (num == 0){
                size0++;
            }
            tmp.add(String.valueOf(num));
        }
        if (size0 == nums.length){
            return "0";
        }

        Collections.sort(tmp, (o1, o2) -> (o1+o2).compareTo(o2 + o1));

        StringBuffer buffer = new StringBuffer();
        for (int i = tmp.size() - 1; i >= 0; --i){
            buffer.append(tmp.get(i));
        }
        return buffer.toString();
    }
}
