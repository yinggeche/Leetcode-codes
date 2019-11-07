/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // Create two data structure to store the result
        List<Integer> res = new ArrayList<>();
        // To store the traversal elements
        Queue<TreeNode> queue = new LinkedList<>();
        // 基础条件判断
        if (root == null){
            return res;
        }

        // Insert the root into the queue
        queue.offer(root);

        // Start traverse
        while (!queue.isEmpty()){
            int count = queue.size();
            TreeNode head = queue.element();
            while (count > 0){
                TreeNode curr = queue.element();
                queue.poll();
                if(curr.right != null){
                    queue.offer(curr.right);
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                count--;
            }
            if (count == 0){
                res.add(head.val);

            }
            // System.out.println("Current Queue:");
            //  for (TreeNode x : queue) {
            //      System.out.println(x.val);
            //     }
        }
        return res;
    }
}
