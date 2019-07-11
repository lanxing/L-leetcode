package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (47.17%)
 * Total Accepted:    10.4K
 * Total Submissions: 21.2K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

import java.util.ArrayList;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        int flag = 0;
        int start = 0;
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        while (start < nodeList.size()){
            List<Integer> tmp = new ArrayList<>();
            int end = nodeList.size();
            if (flag % 2 == 0){
                for (int i = start; i < end; ++i){
                    TreeNode treeNode = nodeList.get(i);
                    tmp.add(treeNode.val);
                    if (treeNode.left != null){
                        nodeList.add(treeNode.left);
                    }
                    if (treeNode.right != null){
                        nodeList.add(treeNode.right);
                    }

                }
            }else {
                for (int i = end - 1; i >= start; --i){
                    TreeNode treeNode = nodeList.get(i);
                    tmp.add(treeNode.val);
                    treeNode = nodeList.get(end - i - 1 + start);
                    if (treeNode.left != null){
                        nodeList.add(treeNode.left);
                    }
                    if (treeNode.right != null){
                        nodeList.add(treeNode.right);
                    }
                }
            }
            result.add(tmp);
            start = end;
            flag++;
        }
        return result;
    }
}
