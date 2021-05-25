package com.wm.LeeCode.LeeCode.tree;

import java.util.LinkedList;
import java.util.List;

public class LeeCode95 {

    public List<LeeCode100.TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new LinkedList<LeeCode100.TreeNode>();
        }

        return generateTrees(1 ,n);
    }

    public List<LeeCode100.TreeNode> generateTrees(int start, int end) {
        List<LeeCode100.TreeNode> allTrees = new LinkedList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; ++i) {
            List<LeeCode100.TreeNode> leftTrees = generateTrees(start, i - 1);

            List<LeeCode100.TreeNode> rightTrees = generateTrees(i + 1, end);

            for (LeeCode100.TreeNode left : leftTrees) {
                for (LeeCode100.TreeNode right : rightTrees) {
                    LeeCode100.TreeNode currTree = new LeeCode100.TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
