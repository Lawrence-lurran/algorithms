//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 注意：本题与主站 199 题相同：https://leetcode-cn.com/problems/binary-tree-right-side-
//view/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 16 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Java：二叉树的右侧视图
@SuppressWarnings("all")
class P剑指OfferII046WNC0Lk{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII046WNC0Lk().new Solution();
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
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int length=queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node=queue.remove();
                if (i==length-1){
                    res.add(node.val);
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
