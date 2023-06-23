package org.ik.tree.test;

import java.util.Stack;

public class KthSmallestElementOfBST {

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


    static Integer kth_smallest_element(BinaryTreeNode root, Integer k) {
        // Write your code here.
        int[] ret = {0};
        helper(root, new int []{k}, ret);
        return ret[0];
    }

    private static void helper(BinaryTreeNode root, int[] k, int[] value) {
        if(k[0] < 0){
            return;
        }
        if(root.left != null){
            helper(root.left, k, value);
        }
        k[0]--;

        if(k[0] == 0){
            value[0] = root.value;;
            k[0]--;
            return;
        }


        if(root.right != null){
            helper(root.right, k, value);
        }
    }

    static class TreeIterator{
        BinaryTreeNode root;
        Stack<IteratorEntry> stack = new Stack<>();

        public TreeIterator(BinaryTreeNode root) {
            this.root = root;
            travelLeft(root);
        }

        private void travelLeft(BinaryTreeNode root) {
            while(root != null){
                stack.add(new IteratorEntry(root));
                root = root.left;
            }
        }

        public Integer next(){
            if(stack.isEmpty()){
                return null;
            }
            IteratorEntry current = stack.peek();
            assert(current.node.left == null);
            if(!current.visitedValue){
                current.visitedValue = true;
                return current.node.value;
            }
            if(!current.visitedRight){
                travelLeft(current.node.right);
                current.visitedRight = true;
                return next();
            }
            stack.pop();
            return next();
        }
    }

    static class IteratorEntry {
        BinaryTreeNode node;
        boolean visitedValue = false;
        boolean visitedRight = false;

        public IteratorEntry(BinaryTreeNode node) {
            this.node = node;
        }
    }


}
