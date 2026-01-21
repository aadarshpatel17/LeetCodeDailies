package org.practise.leetcode_dailies;

public class LC_1339 {
    // 1339. Maximum Product of Splitted Binary Tree
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    // just the format from the problem
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private long maxProduct = 0;
    private long totalSum = 0;
    private static final int MOD = 1_000_000_007;

    // First DFS: calculate total sum of the tree;
    private long getMaxProduct(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return root.val + getMaxProduct(root.left) + getMaxProduct(root.right);
    }

    // Second DFS: compute subtree sum and max product;
    private long compute(TreeNode root) {
        if(root == null) {
            return 0;
        }

        long leftSum = compute(root.left);
        long rightSum = compute(root.right);
        long subtreeSum = root.val + leftSum + rightSum;

        // try cutting above the subtree
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(product, maxProduct);
        return subtreeSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = getMaxProduct(root);
        compute(root);
        return (int)(maxProduct % MOD);
    }
}
