package org.ik.tree;

import java.util.ArrayList;

public class InsertIntoTree {



    static BinaryTreeNode build_a_bst(ArrayList<Integer> values) {
        if(values == null || values.isEmpty()){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(values.get(0));
        for(int i = 1; i < values.size(); i++){
            insert(root, values.get(i));
        }
        return root;
    }

    private static void insert(BinaryTreeNode root, Integer v) {
        BinaryTreeNode previous = null;
        BinaryTreeNode current = root;
        while(current != null){
            int compare = v.compareTo(current.value);
            if(compare == 0){
                //already exists. do nothing
                return;
            } else if(compare > 0){
                previous = current;
                current = current.right;
            } else {
                previous = current;
                current = current.left;
            }
        }

        if(v.compareTo(previous.value) > 0){
            previous.right = new BinaryTreeNode(v);
        } else {
            previous.left = new BinaryTreeNode(v);
        }
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
