//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1088 👎 0

package leetcode.editor.cn;
//Java：二叉树的最大深度
class P104MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
        // TO TEST
        TreeNode root=new TreeNode(3);
        TreeNode root1=new TreeNode(9);
        TreeNode root2=new TreeNode(20);
        TreeNode root3=new TreeNode(15);
        TreeNode root4=new TreeNode(7);
        root.left=root1;
        root.right=root2;
        root2.left=root3;
        root2.right=root4;
        solution.maxDepth(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public int maxDepth(TreeNode root) {
       if (root==null){
           return 0;
       }
       int leftDepth=maxDepth(root.left);
       int rightDepth=maxDepth(root.right);
       return Math.max(leftDepth,rightDepth)+1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
