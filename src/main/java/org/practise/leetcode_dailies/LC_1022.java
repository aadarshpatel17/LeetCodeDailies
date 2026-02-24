package org.practise.leetcode_dailies;

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class LC_1022 {

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
