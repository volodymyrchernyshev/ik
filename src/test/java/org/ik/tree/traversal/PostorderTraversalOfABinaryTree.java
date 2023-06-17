package org.ik.tree.traversal;

import java.util.ArrayList;

public class PostorderTraversalOfABinaryTree {

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

    static ArrayList<Integer> postorder(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }

    private static void helper(BinaryTreeNode root, ArrayList<Integer> ret) {
        if(root == null){
            return;
        }
        helper(root.left, ret);
        helper(root.right, ret);
        ret.add(root.value);
    }

}
