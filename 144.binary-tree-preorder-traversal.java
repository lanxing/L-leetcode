/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (57.59%)
 * Total Accepted:    23.7K
 * Total Submissions: 39.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

import java.util.*;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        treeNodes.push(root);
        while (treeNodes.size() != 0){
            TreeNode tmp = treeNodes.pop();
            result.add(tmp.val);
            if (tmp.right != null){
                treeNodes.push(tmp.right);
            }
            if (tmp.left != null){
                treeNodes.push(tmp.left);
            }
        }
        return result;
    }
}
