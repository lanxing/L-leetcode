/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (71.24%)
 * Total Accepted:    7.7K
 * Total Submissions: 10.7K
 * Testcase Example:  '3'
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int totalLen = n * n;
        int i = 1;
        int level = 0;
        int totalLevel = n % 2 == 0 ? n / 2 : n / 2 + 1;
        while (level < totalLen){
            for (int col = level; col < n - level; ++col){
                result[level][col] = i++;
            }
            for (int row = level + 1; row < n - level; ++row){
                result[row][n - level - 1] = i++;
            }
            for (int col = n - level - 2; col >= level; --col){
                result[n - level - 1][col] = i++;
            }
            for (int row = n - level - 2; row > level; --row){
                result[row][level] = i++;
            }
            level++;
        }
        return result;
    }
}
