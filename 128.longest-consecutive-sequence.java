import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (41.64%)
 * Total Accepted:    7.8K
 * Total Submissions: 18K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 每个连续序列的最边界记录最常长度
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num, 1);
                boolean hasLeft = false;
                int left = 0;
                if (map.containsKey(num - 1)){
                    int leftLong = map.get(num - 1);
                    left = num - leftLong;
                    map.put(left, leftLong + map.get(num));
                    map.put(num, map.get(left));

                    hasLeft = true;
                }
                if (map.containsKey(num + 1)){
                    int rightLong = map.get(num + 1);
                    map.put(num + rightLong, rightLong + map.get(num));
                    map.put(num, rightLong + map.get(num));
                }
                if (hasLeft){
                    map.put(left, map.get(num));
                }
                longest = Math.max(longest, map.get(num));
            }
        }
        return longest;
    }
}
