package com.wm.LeeCode.LeeCode.tree;

/**
 * @author wm
 * @Package com.wm.LeeCode.LeeCode.tree
 * @date 2021/3/10 15:22
 */
public class LeeCode101 {
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

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }
}
