package org.ik.tree.practice;

import java.util.ArrayList;

public class PrintAllPathsOfATree {

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
    static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        printPaths(ret, root, new ArrayList<Integer>());

        return ret;
    }

    private static void printPaths(ArrayList<ArrayList<Integer>> ret, BinaryTreeNode root, ArrayList<Integer> slate) {
        slate.add(root.value);
        if(root.left == null && root.right == null){
            ret.add(new ArrayList<>(slate));
            return;
        }

        if(root.left != null){
            printPaths(ret, root.left, slate);
        }
        if(root.right != null){
            printPaths(ret, root.right, slate);
        }
        slate.remove(slate.size() -1);
    }


}
