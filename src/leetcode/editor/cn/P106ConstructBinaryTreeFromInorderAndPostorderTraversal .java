//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 651 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从中序与后序遍历序列构造二叉树
class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // TO TEST
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inorderMap=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }

        return buildMyTree(postorder,inorderMap,0,postorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildMyTree(int[] postorder, Map<Integer, Integer> inorderMap, int postorderLeft, int postorderRight, int inorderLeft, int inorderRight) {
        if (postorderLeft>postorderRight){
            return null;
        }
        int postorderRoot=postorderRight;
        TreeNode root=new TreeNode(postorder[postorderRoot]);
        int inorderRoot=inorderMap.get(postorder[postorderRoot]);
        int leftSize=inorderRoot-inorderLeft;
        root.left=buildMyTree(postorder,inorderMap,postorderLeft,postorderLeft+leftSize-1,inorderLeft,inorderRoot-1);
        root.right=buildMyTree(postorder,inorderMap,postorderLeft+leftSize,postorderRoot-1,inorderRoot+1,inorderRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
