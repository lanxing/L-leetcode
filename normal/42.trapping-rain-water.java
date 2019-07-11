package lalgorithm.normal;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (42.04%)
 * Total Accepted:    10.2K
 * Total Submissions: 24.1K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */
class Solution {
    public int trap(int[] height) {
        return solution1(height);
    }

    /**
     * https://www.cnblogs.com/felixfang/p/3713197.html
     * @param height
     * @return
     */
    private int solution1(int[] height){
        if (height.length <= 2){
            return 0;
        }
        int maxInd = 0;
        int len = height.length;
        int max = height[maxInd];
        for (int i = 1; i < len; ++i){
            if (max < height[i]){
                max = height[i];
                maxInd = i;
            }
        }

        int area = 0;
        int root = height[0];
        for (int i = 1; i < maxInd; ++i){
            if (root < height[i]){
                root = height[i];
            }else {
                area += (root - height[i]);
            }
        }
        root = height[len - 1];
        for (int i = len - 2; i > maxInd; --i){
            if (root < height[i]){
                root = height[i];
            }else {
                area += (root - height[i]);
            }
        }
        return area;
    }
}
