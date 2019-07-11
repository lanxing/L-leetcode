package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (33.89%)
 * Total Accepted:    7.1K
 * Total Submissions: 20.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * 输出: 6
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * 输出: 42
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
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        compute(root);
        return res;
    }
    private int compute(TreeNode root){
        if(root == null){
            return 0;
        }
        //经过左节点的路径的最大和
        int lMax = compute(root.left);
        //经过右节点的路径的最大和
        int rMax = compute(root.right);
        //以当前节点为根节点的路径最大和
        res = Math.max(res,Math.max(0,lMax)+Math.max(0,rMax)+root.val);
        //返回 经过当前节点的路径最大和
        return Math.max(0,Math.max(lMax,rMax)+root.val);
    }
}
