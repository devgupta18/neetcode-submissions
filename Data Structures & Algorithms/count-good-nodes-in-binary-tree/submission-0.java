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
    private int maxSoFar = 0, ans = 0;

    public void goodNodesCount(TreeNode root, int maxSoFar) {
        if(root == null) return;
        if(root.val >= maxSoFar) ans += 1;
        goodNodesCount(root.left, Math.max(maxSoFar, root.val));
        goodNodesCount(root.right, Math.max(maxSoFar, root.val));
    }

    public int goodNodes(TreeNode root) {
        maxSoFar = root.val;
        goodNodesCount(root, maxSoFar);
        return ans;
    }
}
