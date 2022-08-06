//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：一个机器人每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
//
// 
//
// 注意：本题与主站 64 题相同： https://leetcode-cn.com/problems/minimum-path-sum/ 
// Related Topics 数组 动态规划 矩阵 👍 12 👎 0

package leetcode.editor.cn;
//Java：最小路径之和
@SuppressWarnings("all")
class P剑指OfferII099ZeroI0mDW{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII099ZeroI0mDW().new Solution();
        // TO TEST
        solution.minPathSum(new int[][]{{1,2,3},{4,5,6}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int len1=grid.length;
        int len2=grid[0].length;
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < len2; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int j = 1; j < len1; j++) {
            dp[j][0]=dp[j-1][0]+grid[j][0];
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[len1-1][len2-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
