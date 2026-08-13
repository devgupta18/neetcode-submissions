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
    private int cntr = 0, ans = 0;

    public void smallest(TreeNode root, int k) {
        if(root == null) return;
        smallest(root.left, k);
        cntr++;
        if(cntr == k) ans = root.val;
        smallest(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        smallest(root, k);
        return ans;
    }
}