package lalgorithm.normal;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 *
 * https://leetcode-cn.com/problems/maximum-gap/description/
 *
 * algorithms
 * Hard (47.78%)
 * Total Accepted:    3.6K
 * Total Submissions: 7.1K
 * Testcase Example:  '[3,6,9,1]'
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 
 * 如果数组元素个数小于 2，则返回 0。
 * 
 * 示例 1:
 * 
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 
 * 示例 2:
 * 
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 
 * 说明:
 * 
 * 
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * 
 * http://nfeng.cc/2016/03/15/maximum-gap-problem/
 */
class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            if (max < num){
                max = num;
            }
            if (min > num){
                min = num;
            }
        }
        if (len == 2 || max - min < 1){
            return max - min;
        }
        //每个桶中数据间隔
        int interval = (max - min) / (len - 1);
        if (interval == 0){
            interval = 1;
        }
        //桶个数
        int buckNum = (max - min) / interval + 1;
        List<List<Integer>> tmp = new ArrayList<>(buckNum);
        for (int i = 0; i < buckNum; ++i){
            tmp.add(new ArrayList<>());
        }
        for (int num : nums){
            int index = (num - min) / interval;
            List<Integer> bucket = tmp.get(index);
            if (bucket.size() == 0){
                bucket.add(num);
                bucket.add(num);
            }else if (bucket.get(0) < num){
                bucket.set(0, num);
            }else if (bucket.get(1) > num){
                bucket.set(1, num);
            }
        }

        int maxInterval = Integer.MIN_VALUE;
        int first = -1;
        for (List<Integer> bucket : tmp){
            if (bucket.size() == 0){
                continue;
            }else if (first == -1){
                first = bucket.get(0);
            }else {
                maxInterval = Math.max(maxInterval, bucket.get(1) - first);
                first = bucket.get(0);
            }
        }
        return maxInterval;
    }
}
