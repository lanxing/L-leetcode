package lalgorithm.normal;

/*
 * @lc app=leetcode.cn id=775 lang=java
 *
 * [775] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/global-and-local-inversions/description/
 *
 * algorithms
 * Medium (43.52%)
 * Total Accepted:    782
 * Total Submissions: 1.9K
 * Testcase Example:  '[0]'
 *
 * 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 <= i < j < N 并且
 * A[i] > A[j] ，局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。
 * 
 * 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: A = [1,0,2]
 * 输出: true
 * 解释: 有 1 个全局倒置，和 1 个局部倒置。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: A = [1,2,0]
 * 输出: false
 * 解释: 有 2 个全局倒置，和 1 个局部倒置。
 * 
 * 
 * 注意:
 * 
 * 
 * A 是 [0, 1, ..., A.length - 1] 的一种排列
 * A 的长度在 [1, 5000]之间
 * 这个问题的时间限制已经减少了。
 * 
 * 
 */
class Solution {
    public boolean isIdealPermutation(int[] A) {
        
    }
}
