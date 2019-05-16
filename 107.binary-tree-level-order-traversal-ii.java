/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (59.26%)
 * Total Accepted:    15.3K
 * Total Submissions: 25.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> nodeDeque = new ArrayList<>();
        nodeDeque.add(root);
        int start = 0;
        while (start < nodeDeque.size()){
            int len = nodeDeque.size();
            List<Integer> tmpResult = new ArrayList<>();
            for (int i = start; i < len; ++i){
                TreeNode node = nodeDeque.get(i);
                tmpResult.add(node.val);
                if (node.left != null){
                    nodeDeque.add(node.left);
                }
                if (node.right != null){
                    nodeDeque.add(node.right);
                }
            }
            start = len;
            result.add(tmpResult);
        }
        Collections.reverse(result);
        return result;
    }
}
