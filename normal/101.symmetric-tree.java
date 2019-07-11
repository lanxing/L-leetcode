package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (45.33%)
 * Total Accepted:    31.9K
 * Total Submissions: 68.8K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val == right.val){
            return recursion(left.left, right.right) && recursion(left.right, right.left);
        }
        return false;
    }

    private boolean iteration(TreeNode root){
        List<TreeNode> nodeDeque = new ArrayList<>();
        nodeDeque.add(root);
        int index = 0;
        while (!nodeDeque.isEmpty()){
            int tmpIndex = nodeDeque.size();
            int end = nodeDeque.size() - 1;
            while (index <= end){
                TreeNode leftNode = nodeDeque.get(index);
                TreeNode rightNode = nodeDeque.get(end);
                if (leftNode == null && rightNode == null){

                }else if (leftNode == null || rightNode == null){
                    return false;
                }else if (leftNode.val != rightNode.val){
                    return false;
                }
                index++;
                end--;
            }
            for (int i = index; i < nodeDeque.size(); ++i){
                if (nodeDeque.get(i) != null){
                    nodeDeque.add(nodeDeque.get(i).left);
                    nodeDeque.add(nodeDeque.get(i).right);
                }
            }
            index = tmpIndex;
        }
        return true;
    }
}
