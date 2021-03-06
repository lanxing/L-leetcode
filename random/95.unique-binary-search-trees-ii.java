/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (50.66%)
 * Total Accepted:    3.6K
 * Total Submissions: 7.1K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }
    private List<TreeNode> generateTree(int left, int right){
        List<TreeNode> nodeList = new ArrayList<>();
        if (left > right){
            nodeList.add(null);
            return nodeList;
        }else if (left == right){
            nodeList.add(new TreeNode(left));
            return nodeList;
        }
        for (int i = left; i <= right; ++i){
            List<TreeNode> lefts = generateTree(left, i - 1);
            List<TreeNode> rights = generateTree(i + 1, right);
            for (TreeNode leftNode : lefts){
                for (TreeNode rightNode : rights){
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }
}
