package org.practise.leetcode_dailies._01_jan;

import org.practise.leetcode_dailies.TreeNode;

public class LC_07 {

    // 1339. Maximum Product of Splitted Binary Tree

    private long maxProduct = 0;
    private long totalSum = 0;
    private static final int MOD = 1_000_000_007;

    // First DFS: calculate total sum of the tree;
    private long getMaxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + getMaxProduct(root.left) + getMaxProduct(root.right);
    }

    // Second DFS: compute subtree sum and max product;
    private long compute(TreeNode root) {
        if (root == null) {
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
        return (int) (maxProduct % MOD);
    }
}
