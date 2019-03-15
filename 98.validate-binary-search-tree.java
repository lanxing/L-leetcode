/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (24.70%)
 * Total Accepted:    16.5K
 * Total Submissions: 66.7K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return solution1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 限定了子树节点的值得范围，从而每个节点只需遍历一次。节点值的初始范围可限定为TNT_MIN以及TNT_MAX。
     * @param node
     * @param min
     * @param max
     * @return
     */
    public boolean solution1(TreeNode node, long min, long max){
        if (node == null){
            return true;
        }
        if (node.val < min || node.val > max){
            return false;
        }
        return solution1(node.left, min, (long)node.val - 1) && solution1(node.right, (long)node.val + 1, max);
    }
}
