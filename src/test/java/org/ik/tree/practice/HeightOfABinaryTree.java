package org.ik.tree.practice;

public class HeightOfABinaryTree {



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

    static Integer height_of_binary_tree(BinaryTreeNode root) {
        // Write your code here.
        if(root == null){
            return 0;
        }

        return Math.max(height_of_binary_tree(root.left), height_of_binary_tree(root.right)) +1;
    }


}
