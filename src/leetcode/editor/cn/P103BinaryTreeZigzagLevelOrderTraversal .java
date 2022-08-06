//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 574 👎 0

package leetcode.editor.cn;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Java：二叉树的锯齿形层序遍历
class P103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        solution.zigzagLevelOrder(root);

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<TreeNode> deque=new ArrayDeque<>();
        if (root==null){
            return res;
        }
        deque.offer(root);
        boolean reverse=true;
        while (!deque.isEmpty()){
            int size=deque.size();
            List<Integer> temp=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                if (reverse){
                    node=deque.removeFirst();
                }else{
                    node=deque.removeLast();
                }
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
                temp.add(node.val);

            }
            res.add(temp);
            reverse=!reverse;

        }

        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
