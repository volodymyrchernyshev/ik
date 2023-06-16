package org.ik.tree;

public class MaxValueTree {

    static Integer get_maximum_value(BinaryTreeNode root) {
        if(root == null){
            return null;
        }

        while(root.right != null){
            root = root.right;
        }
        return root.value;
    }


    static class BinaryTreeNode {
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
