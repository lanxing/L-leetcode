package lalgorithm.normal;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (37.22%)
 * Total Accepted:    4.7K
 * Total Submissions: 12.5K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * https://www.cnblogs.com/grandyang/p/4322653.html
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        return solution1(heights);
    }

    /**
     * 遍历每个柱子，向左向右寻找比这个柱子高的柱子，然后计算宽度和高度，求出矩形面积
     * @param heights
     * @return
     */
    public int solution1(int[] heights){
        int len = heights.length;
        int max = 0;
        int i = 0;
        while (i < len){
            int j = i;
            max = Math.max(heights[j], max);
            int left = -1;
            int right = -1;
            int k;
            //向左扫描(left指向最后一个比当前值大的)
            for (k = j; k >= 0; --k){
                if (heights[k] < heights[j]){
                    left = k + 1;
                    break;
                }
            }
            if (k == -1){
                left = 0;
            }
            //向右扫描(right指向最后一个比当前值大的)
            for (k = j; k < heights.length; ++k){
                if (heights[k] < heights[j]){
                    right = k - 1;
                    break;
                }
            }
            if (k == heights.length){
                right = heights.length - 1;
            }
            max = Math.max(max, (heights[j] * (right - left + 1)));
            ++i;
        }
        return max;
    }

    /**
     * 单调栈解决
     * @param heights
     * @return
     */
    public int solution2(int[] heights){
        if (heights.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int height;
        int left;
        for (int i = 0; i < heights.length; ++i){
            int cur = heights[i];
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && cur <= heights[stack.peek()]){
                    left = stack.pop();
                    height = heights[left];
                    max = Math.max(max, (i - left) * height);
                }
                stack.push(i);
            }
        }
        int curDix = 0;
        if (!stack.isEmpty()){
            curDix = stack.peek();
        }
        while (!stack.isEmpty()){
            max = Math.max(max, (curDix - stack.peek() + 1) * heights[stack.peek()]);
            stack.pop();
        }

        return max;
    }
}
