package lalgorithm.normal;

import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (57.20%)
 * Total Accepted:    12.4K
 * Total Submissions: 21K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][]minimus = new int[len][len];
        for (int i = 0; i < len; ++i){
            minimus[len - 1][i] = triangle.get(len - 1).get(i);
        }

        for (int i = len - 2; i >= 0; --i){
            for (int j = 0; j <= i; ++j){
                minimus[i][j] = triangle.get(i).get(j) + Math.min(minimus[i + 1][j], minimus[i + 1][j + 1]);
            }
        }
        return minimus[0][0];
    }

    /**
     * O(n)空间复杂度
     * @param triangle
     * @return
     */
    public int minimumTotalN(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[]minimus = new int[len];
        for (int i = 0; i < len; ++i){
            minimus[i] = triangle.get(len - 1).get(i);
        }

        for (int i = len - 2; i >= 0; --i){
            for (int j = 0; j <= i; ++j){
                minimus[j] = triangle.get(i).get(j) + Math.min(minimus[j], minimus[j + 1]);
            }
        }
        return minimus[0];
    }
}
