package com.wm.interviewing;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = null;
            rightChild = null;
        }
    }

    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<Node> nodeList = null;

    public void createBinTree() {
        nodeList = new LinkedList<>();
        for (int nodeIndex = 0; nodeIndex < array.length; ++nodeIndex) {
            nodeList.add(new Node(array[nodeIndex]));
        }

        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; ++parentIndex) {
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }

        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex * 2 + 1);
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex * 2 + 2);
        }
    }
}
