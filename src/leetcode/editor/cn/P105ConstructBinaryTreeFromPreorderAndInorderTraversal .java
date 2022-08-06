//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1380 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    Map<Integer,Integer> inorderMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return buildMyTree(preorder,inorderMap,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildMyTree(int[] preorder, Map<Integer,Integer> inorderMap, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft>preRight){
            return null;
        }
        int preRoot=preLeft;
        TreeNode root=new TreeNode(preorder[preRoot]);
        int inRoot=inorderMap.get(preorder[preRoot]);
        int leftSize=inRoot-inLeft;

        root.left=buildMyTree(preorder,inorderMap,preLeft+1,leftSize+preLeft,inLeft,inRoot-1);
        root.right=buildMyTree(preorder,inorderMap,leftSize+preLeft+1,preRight,inRoot+1,inRight);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
