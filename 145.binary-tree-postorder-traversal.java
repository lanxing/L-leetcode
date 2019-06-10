/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (64.14%)
 * Total Accepted:    17.8K
 * Total Submissions: 27.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (right != null && !visited.contains(right)){
                stack.push(right);
            }
            if (left != null && !visited.contains(left)){
                stack.push(left);
            }
            if (left == null && right == null){
                result.add(node.val);
                visited.add(node);
                stack.pop();
            } else if (visited.contains(left) || visited.contains(right)){
                result.add(node.val);
                visited.add(node);
                stack.pop();
            }
        }
        return result;

    }
}
