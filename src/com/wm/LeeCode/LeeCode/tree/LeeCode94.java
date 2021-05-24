package com.wm.LeeCode.LeeCode.tree;

import java.util.ArrayList;
import java.util.List;

public class LeeCode94 {
    public List<Integer> inorderTraversal(LeeCode100.TreeNode root) {
/*
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(LeeCode100.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    */
       /*
        List<Integer> res = new ArrayList<Integer>();
        Deque<LeeCode100.TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
        */

        List<Integer> res = new ArrayList<>();
        LeeCode100.TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
