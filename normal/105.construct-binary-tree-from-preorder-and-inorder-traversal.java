package lalgorithm.normal;/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (56.39%)
 * Total Accepted:    12.6K
 * Total Submissions: 21.8K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,  0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }


    public TreeNode buildTree(int[] preOrder, int pl, int pr, int[] inOrder, int il, int ir){
        if (pl > pr){
            return null;
        }
        int val = preOrder[pl];
        TreeNode node = new TreeNode(val);
        if (pl == pr){
            return node;
        }
        int mid = 0;
        for (int i = il; i <= ir; ++i){
            if (inOrder[i] == val){
                mid = i;
                break;
            }
        }
        int pmid = pl + mid - il;
        TreeNode left = buildTree(preOrder, pl + 1, pmid, inOrder, il, mid - 1);
        TreeNode right = buildTree(preOrder, pmid + 1, pr, inOrder, mid + 1, ir);
        node.left = left;
        node.right = right;
        return node;
    }
}
