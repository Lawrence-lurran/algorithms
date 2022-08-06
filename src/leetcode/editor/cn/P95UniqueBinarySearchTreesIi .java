//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1102 👎 0

package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

//Java：不同的二叉搜索树 II
class P95UniqueBinarySearchTreesIi{
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
        // TO TEST
        solution.generateTrees(3);
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
    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new LinkedList<TreeNode>();
        }
        return generate(1,n);
    }

    public List<TreeNode> generate(int start,int end){
        List<TreeNode> res=new LinkedList<>();
        if (start>end){
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree=generate(start,i-1);
            List<TreeNode> rightTree=generate(i+1,end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode cur=new TreeNode(i);
                    cur.left=left;
                    cur.right=right;
                    res.add(cur);
                }
            }
        }

        return res;
    }


}


//leetcode submit region end(Prohibit modification and deletion)

}
