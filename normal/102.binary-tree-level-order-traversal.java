package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (53.99%)
 * Total Accepted:    25.1K
 * Total Submissions: 45.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> tmp = new ArrayList<>();
        tmp.add(root);
        while (!tmp.isEmpty()){
            List<TreeNode> tmpF = new ArrayList<>(tmp.size() * 2);
            List<Integer> tmpR = new ArrayList<>(tmp.size());
            for (TreeNode node : tmp){
                tmpR.add(node.val);
                if (node.left != null) {
                    tmpF.add(node.left);
                }
                if (node.right != null) {
                    tmpF.add(node.right);
                }
            }
            result.add(tmpR);
            tmp = tmpF;
        }
        return result;
    }
}
