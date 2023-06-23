package org.ik.tree.practice;

import java.util.*;

public class FlipUpsideDown {


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

    static BinaryTreeNode flip_upside_down(BinaryTreeNode root) {
        //every root to put in a queue;
        //find the very left
        //left becomes root, right becomes left, root becomes right; repeat

        if(root == null || root.left == null){
            return root;
        }

        Stack<BinaryTreeNode> nodes = new Stack<>();
        while(root != null){
            nodes.add(root);
            root = root.left;
        }

        BinaryTreeNode ret = nodes.pop();
        BinaryTreeNode newRoot = ret;

        while(!nodes.isEmpty()){
            BinaryTreeNode previous = nodes.pop();
            newRoot.left = previous.right;
            newRoot.right = new BinaryTreeNode(previous.value);
            newRoot = newRoot.right;
        }


        return ret;
    }

}
