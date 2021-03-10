package com.wm.LeeCode.LeeCode.tree;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.tree
 * @date 2021/3/10 15:52
 */
public class LeeCode104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHight = maxDepth(root.right);
            return Math.max(leftHeight, rightHight) + 1;
        }
    }
    
}
