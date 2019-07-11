package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (67.41%)
 * Total Accepted:    45.5K
 * Total Submissions: 66K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
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
    private static int max = 0;

    public int maxDepth(TreeNode root) {
//        max = 0;
//        maxDepth(root, 0);
//        return max;
        return maxPath(root);
    }

    private void maxDepth(TreeNode node, int cur){
        if (node == null){
            max = Math.max(max, cur);
            return;
        }
        maxDepth(node.left, cur + 1);
        maxDepth(node.right, cur + 1);
    }

    private int maxPath(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = maxPath(root.left);
        int right = maxPath(root.right);

        return left > right ? left + 1 : right + 1;
    }
}
