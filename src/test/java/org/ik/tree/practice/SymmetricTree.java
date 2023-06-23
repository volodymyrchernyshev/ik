package org.ik.tree.practice;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

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


    static Boolean check_if_symmetric(BinaryTreeNode root) {
        // Write your code here.
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        if(root.left == null || root.right == null){
            return false;
        }

        TreeIterator left = new TreeIterator(root.left, true);
        TreeIterator right = new TreeIterator(root.right, false);

        while(!left.isEmpty() && !right.isEmpty()){
            if(compare(left.next(), right.next())){
                return false;
            }
        }

        if(left.isEmpty() && right.isEmpty()){
            return true;
        }

        return false;
    }

    private static boolean compare(Integer a, Integer b) {
        System.out.printf("a: %d, b:%d", a , b);
        if(a == null && b == null){
            return true;
        }

        if(a == null || b == null){
            return false;
        }

        return a.compareTo(b) == 0;
    }

    static class TreeIterator{
        private final Queue<BinaryTreeNode> queue;
        boolean order;
        public TreeIterator(BinaryTreeNode root, boolean order){
            this.queue = new LinkedList<BinaryTreeNode>();
            this.order = order;
            this.queue.add(root);
        }
        public boolean isEmpty() {
            return queue.isEmpty();
        }
        public Integer next() {
            BinaryTreeNode node = queue.poll();
            if(node == null){
                return null;
            }
            if(order) {
                queue.add(node.left);
                queue.add(node.right);
            } else {
                queue.add(node.right);
                queue.add(node.left);
            }
            return node.value;
        }
    }


}
