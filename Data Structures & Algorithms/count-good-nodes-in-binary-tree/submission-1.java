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

class Solution {
    private int maxSoFar = 0;

    public int goodNodesCount(TreeNode root, int maxSoFar) {
        if(root == null) return 0;
        int left = goodNodesCount(root.left, Math.max(maxSoFar, root.val));
        int right = goodNodesCount(root.right, Math.max(maxSoFar, root.val));
        if(root.val >= maxSoFar) return 1 + left + right;
        else return 0 + left + right;
    }

    public int goodNodes(TreeNode root) {
        maxSoFar = root.val;
        return goodNodesCount(root, maxSoFar);
    }
}
