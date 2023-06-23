package org.ik.tree.test;

import java.util.ArrayList;

public class HeightOfATree {

    class TreeNode {
        Integer value;
        ArrayList<TreeNode> children;

        TreeNode(Integer value) {
            this.value = value;
            this.children = new ArrayList(3);
        }
    }

    static Integer find_height(TreeNode root) {
        // Write your code here.

        if(root == null || root.children == null || root.children.isEmpty()){
            return 1;
        }

        int maxHeight = 0;
        for (TreeNode child : root.children) {
            maxHeight = Math.max(maxHeight, find_height(child));

        }

        return maxHeight + 1;
    }



}
