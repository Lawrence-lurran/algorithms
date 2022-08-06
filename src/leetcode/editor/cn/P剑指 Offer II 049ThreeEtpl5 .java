//给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。 
//
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
//
// 
//
// 注意：本题与主站 129 题相同： https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/ 
//
// Related Topics 树 深度优先搜索 二叉树 👍 14 👎 0

package leetcode.editor.cn;

import java.util.List;

//Java：从根节点到叶节点的路径数字之和
@SuppressWarnings("all")
class P剑指OfferII049ThreeEtpl5{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII049ThreeEtpl5().new Solution();
        // TO TEST
        TreeNode root1=new TreeNode(4);
        TreeNode root2=new TreeNode(9);
        TreeNode root3=new TreeNode(0);
        //TreeNode root4=new TreeNode(5);
        TreeNode root5=new TreeNode(1);
        root1.left=root2;
        root1.right=root3;
        root2.left=null;
        root2.right=root5;
        solution.sumNumbers(root1);
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
    long sum=0;
    int old;
    public int sumNumbers(TreeNode root) {
        perOrder(root,new StringBuffer());
        long res=sum/2;
        return (int)res;
    }
    public void perOrder(TreeNode root,StringBuffer stringBuffer){
        if (root==null){
            int res=Integer.parseInt(stringBuffer.toString());
            sum+=res;
            return;
        }
        stringBuffer.append(root.val);
        if (root.left==null && root.right!=null){

        }else {
            perOrder(root.left,stringBuffer);
        }
        if (root.left!=null && root.right==null){

        }else {
            perOrder(root.right,stringBuffer);
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
