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

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            //也可以改成 while(count-->0)
            //下面两行就可以不要了
          
            while(count>0){
                count--;
                TreeNode tmpNode= queue.poll();
                if(tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
                if(count == 0){
                    res.add(tmpNode.val);
                }

            }

        }
        return res;
    }
}
