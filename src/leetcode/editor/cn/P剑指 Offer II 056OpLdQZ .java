//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 12
//输出: true
//解释: 节点 5 和节点 7 之和等于 12
// 
//
// 示例 2： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 22
//输出: false
//解释: 不存在两个节点值之和为 22 的节点
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 11 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：二叉搜索树中两个节点之和
@SuppressWarnings("all")
class P剑指OfferII056OpLdQZ{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII056OpLdQZ().new Solution();
        // TO TEST
        TreeNode root1=new TreeNode(8);
        TreeNode root2=new TreeNode(6);
        TreeNode root3=new TreeNode(10);
        TreeNode root4=new TreeNode(5);
        TreeNode root5=new TreeNode(7);
        TreeNode root6=new TreeNode(9);
        TreeNode root7=new TreeNode(11);
        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;
        root3.left=root6;
        root3.right=root7;
        solution.findTarget(root1,12);
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
    Set<Integer> nums=new HashSet<>();
    boolean flag=false;
    public boolean findTarget(TreeNode root, int k) {
        perOrder(root,k);
        return flag;
    }
    public void perOrder(TreeNode root,int k){
        if (root==null){
            return;
        }
        if (nums.contains(k-root.val)){
            flag=true;
            return;
        }else {
            nums.add(root.val);
        }
        perOrder(root.left,k);
        perOrder(root.right,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
