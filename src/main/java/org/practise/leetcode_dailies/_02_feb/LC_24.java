package org.practise.leetcode_dailies._02_feb;

import org.practise.leetcode_dailies.TreeNode;

public class LC_24 {

//    1022. Sum of Root To Leaf Binary Numbers
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }

    public int solve(TreeNode root, int value) {
        if(root == null) return 0;

        value = (2 * value) + root.val;

        // if leaf node
        if(root.left == null && root.right == null) {
            return value;
        }

        return solve(root.left, value) + solve(root.right, value);
    }

}
