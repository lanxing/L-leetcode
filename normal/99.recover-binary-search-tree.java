package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 *
 * https://leetcode-cn.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (51.05%)
 * Total Accepted:    2.3K
 * Total Submissions: 4.5K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * 二叉搜索树中的两个节点被错误地交换。
 * 
 * 请在不改变其结构的情况下，恢复这棵树。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * 输出: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * 输出: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 进阶:
 * 
 * 
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * 
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
 * 利用中序遍历找出交换的节点
 */
class Solution {
    private TreeNode lastOne = new TreeNode(Integer.MIN_VALUE);
    private TreeNode first;
    private TreeNode second;

    public void recoverTree(TreeNode root) {
        solution1(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }


    public void solution1(TreeNode root){
        if (root == null){
            return;
        }
        solution1(root.left);
        // 如果first节点未找到，且前一节点值大于当前节点值，说明找到第一个破坏规则的节点位置，即preElement
        if (first == null && lastOne.val > root.val){
            first = lastOne;
        }
        // first节点已找到，且前一节点值大于当前节点值，找到第二个破坏规则的节点位置，即root
        if (first != null && lastOne.val > root.val){
            second = root;
        }
        lastOne = root;
        solution1(root.right);
    }
}
