package org.ik.tree.traversal;

import java.util.ArrayList;

public class PreorderTraversalOfABinaryTree {

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
    static ArrayList<Integer> preorder(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> ret = new ArrayList<>();
        helper(root, ret);

        return ret;
    }

    private static void helper(BinaryTreeNode root, ArrayList<Integer> ret) {
        if(root == null){
            return;
        }
        ret.add(root.value);
        helper(root.left, ret);
        helper(root.right, ret);
    }


}
