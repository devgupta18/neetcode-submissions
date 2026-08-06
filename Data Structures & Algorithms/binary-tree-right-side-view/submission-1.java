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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        q.add(root);
        if(root == null) return ans;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            l.add(level);
        }

        for(int i=0; i<l.size(); i++) {
            int s = l.get(i).size();
            ans.add(l.get(i).get(s-1));
        }

        return ans;
    }
}
