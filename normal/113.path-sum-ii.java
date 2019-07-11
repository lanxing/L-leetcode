package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 *
 * https://leetcode-cn.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (52.52%)
 * Total Accepted:    8.9K
 * Total Submissions: 16.2K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   8
 * ⁠          /   / \
 * ⁠         11  13  4
 * ⁠        /  \    / \
 * ⁠       7    2  5   1
 * 
 * 
 * 返回:
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> tmpList = new ArrayList<>();
        tmpList.add(root);
        backTracing(root, sum, tmpList, result);
        return result;
    }


    public void backTracing(TreeNode root, int sum, List<TreeNode> tmpList, List<List<Integer>> result){
        if (root.left == null && root.right == null){
            if (root.val == sum) {
                List<Integer> tmpValList = new ArrayList<>();
                for (TreeNode node : tmpList) {
                    tmpValList.add(node.val);
                }
                result.add(tmpValList);
            }
            return;
        }
        if (root.left != null){
            tmpList.add(root.left);
            backTracing(root.left, sum - root.val, tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
        if (root.right != null){
            tmpList.add(root.right);
            backTracing(root.right, sum - root.val, tmpList, result);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
