package org.ik.tree.practice;

import org.junit.jupiter.api.Test;

public class SingleValueTree {

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

        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = new BinaryTreeNode(2);
        root.left = left;

        System.out.println(find_single_value_trees(root));
    }


    static Integer find_single_value_trees(BinaryTreeNode root) {

        int[] count = {0};

        isUnivalue(root, count);

        return count[0];

    }

    private static boolean isUnivalue(BinaryTreeNode root, int[] count) {

        if(root.left == null && root.right == null){
            count[0]++;
            return true;
        }

        boolean isSingleValue = true;
        if(root.left != null){
            isSingleValue = isUnivalue(root.left, count) && root.left.value.equals(root.value);
        }

        if(root.right != null){
            isSingleValue = isUnivalue(root.right, count) && isSingleValue && root.right.value.equals(root.value);
        }

        if(isSingleValue){
            count[0]++;
        }

        return isSingleValue;
    }


}
