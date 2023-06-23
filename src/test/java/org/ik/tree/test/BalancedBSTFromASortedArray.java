package org.ik.tree.test;

import java.util.ArrayList;

public class BalancedBSTFromASortedArray {

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


    static BinaryTreeNode build_balanced_bst(ArrayList<Integer> a) {
        // Write your code here.
        return build_balanced_bst(a, 0, a.size() -1);
    }

    private static BinaryTreeNode build_balanced_bst(ArrayList<Integer> a, int l, int r) {

        if(l > r || r < l){
            return null;
        }
        int root = (r - l)/2 + l;

        BinaryTreeNode ret = new BinaryTreeNode(a.get(root));

        ret.left = build_balanced_bst(a, l, root -1);
        ret.right = build_balanced_bst(a, root +1, r);

        return ret;
    }


}
