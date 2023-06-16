package org.ik.tree;

import org.ik.recursion.PalindromicDecompositionOfAString;

public class FindValueInTree {

    static Boolean search_node_in_bst_Recurs(BinaryTreeNode root, Integer value) {
        int compare = root.value.compareTo(value);
        if(compare == 0){
            return true;
        } else if(compare > 0){
            if(root.left == null){
                return false;
            }
            return search_node_in_bst(root.left, value);
        }else {
            if(root.right == null){
                return false;
            }
            return search_node_in_bst(root.right, value);
        }
    }

    static Boolean search_node_in_bst(BinaryTreeNode root, Integer value) {
        BinaryTreeNode current = root;
        while(current != null){
            int compare = current.value.compareTo(value);
            if(compare == 0){
                return true;
            } else if(compare > 0){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return false;
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
