/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (58.33%)
 * Total Accepted:    7.7K
 * Total Submissions: 12.8K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return buildTree(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    public TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr){
        if (pl > pr){
            return null;
        }
        TreeNode node = new TreeNode(postorder[pr]);
        if (pl == pr){
            return node;
        }
        int imid = 0;
        for (int i = il; i <= ir; ++i){
            if (inorder[i] == node.val){
                imid = i;
                break;
            }
        }
        int pmid = pl + imid - il;
        node.left = buildTree(inorder, il, imid - 1, postorder, pl, pmid - 1);
        node.right = buildTree(inorder, imid + 1, ir, postorder, pmid, pr - 1);
        return node;
    }
}
