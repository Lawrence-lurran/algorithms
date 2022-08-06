//给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [5,1,7]
//输出：[1,null,5,null,7]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的取值范围是 [1, 100] 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 897 题相同： https://leetcode-cn.com/problems/increasing-order-search-
//tree/ 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 二叉树 👍 14 👎 0

package leetcode.editor.cn;
//Java：展平二叉搜索树
class P剑指OfferII052NYBBNL{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII052NYBBNL().new Solution();
        // TO TEST
        TreeNode root1=new TreeNode(2);
        TreeNode root2=new TreeNode(1);
        TreeNode root3=new TreeNode(4);
        TreeNode root4=new TreeNode(3);
        root1.left=root2;
        root1.right=root3;
        root3.left=root4;
        solution.increasingBST(root1);

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
    TreeNode head=new TreeNode(0);
    TreeNode next=head;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return head.right;
    }
    public void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        next.right=root;
        root.left=null;
        next=next.right;
        inOrder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
