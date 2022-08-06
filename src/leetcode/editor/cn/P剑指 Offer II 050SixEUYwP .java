//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// 
//
// 注意：本题与主站 437 题相同：https://leetcode-cn.com/problems/path-sum-iii/ 
// Related Topics 树 深度优先搜索 二叉树 👍 14 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：向下的路径节点之和
@SuppressWarnings("all")
class P剑指OfferII050SixEUYwP{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII050SixEUYwP().new Solution();
        // TO TEST
        TreeNode root1=new TreeNode(1);
//        TreeNode root2=new TreeNode(4);
//        TreeNode root3=new TreeNode(8);
//        TreeNode root4=new TreeNode(11);
//        TreeNode root5=new TreeNode(13);
//        TreeNode root6=new TreeNode(4);
//        TreeNode root7=new TreeNode(7);
//        TreeNode root8=new TreeNode(2);
//        TreeNode root9=new TreeNode(5);
//        TreeNode root10=new TreeNode(1);
//        root1.left=root2;
//        root1.right=root3;
//        root2.left=root4;
//        root3.left=root5;
//        root3.right=root6;
//        root4.left=root7;
//        root4.right=root8;
//        root6.left=root9;
//        root6.right=root10;
        solution.pathSum(root1,1);

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
    Map<Integer,Boolean> map=new HashMap<>();
    int res=0;
    public int pathSum(TreeNode root, int targetSum) {
//        map.put(0,true);
        perOrder(root,0,targetSum);
        return res;
    }
    public void perOrder(TreeNode root,int preSum,int targetSum){
        if (root==null){
            return;
        }
        int sum=root.val+preSum;

        if (map.containsKey(sum-targetSum)){
            res++;
        }
        if (root.val==targetSum){
            res++;
        }
        if (sum==targetSum&&root.val!=targetSum){
            res++;
        }
        map.put(sum,true);
        perOrder(root.left,sum,targetSum);
        perOrder(root.right,sum,targetSum);
        map.remove(sum);
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}
