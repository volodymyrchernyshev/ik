package org.ik.tree;

import java.util.ArrayList;

public class LevelOrderTraversalOfABinaryTree {

    static ArrayList<ArrayList<Integer>> level_order_traversal(BinaryTreeNode root) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ArrayList<BinaryTreeNode> queue = new ArrayList<>();
        queue.add(root);

        mainLoop:
        while (true) {
            ArrayList<BinaryTreeNode> newQueue = new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();
            for (BinaryTreeNode node : queue) {
                values.add(node.value);
                if (node.left != null) newQueue.add(node.left);
                if (node.right != null) newQueue.add(node.right);
             }
            ret.add(values);
            if (newQueue.isEmpty()) {
                break mainLoop;
            }
            queue = newQueue;
        }
        return ret;
    }


    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


}
