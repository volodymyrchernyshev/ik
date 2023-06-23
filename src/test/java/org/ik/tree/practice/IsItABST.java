package org.ik.tree.practice;

import org.junit.jupiter.api.Test;

public class IsItABST {

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

    @Test
    public void test(){

    }


    static Boolean is_bst(BinaryTreeNode root) {
        // Write your code here.
        return is_bst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Boolean is_bst(BinaryTreeNode root, int minValue, int maxValue) {
        if(root == null){
            return true;
        }
        if(root.value > minValue && root.value < maxValue ){
            return false;
        }
        if(!is_bst(root.left, minValue, root.value)){
            return false;
        }

        if(!is_bst(root.right, root.value, maxValue)){
            return false;
        }
        return true;
    }


}
