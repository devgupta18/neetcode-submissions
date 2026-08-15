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

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int mid = 0;
        while(inorder[mid] != root.val) mid++;

        int leftSize = mid - inStart;

        root.left = build(preorder, preStart+1, preStart+leftSize, inorder, inStart, mid-1);
        root.right = build(preorder, preStart+leftSize+1, preEnd, inorder, mid+1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
}
