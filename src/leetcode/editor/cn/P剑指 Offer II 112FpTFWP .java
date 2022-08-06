//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 329 题相同： https://leetcode-cn.com/problems/longest-increasing-path-
//in-a-matrix/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 9 👎 0

package leetcode.editor.cn;
//Java：最长递增路径
@SuppressWarnings("all")
class P剑指OfferII112FpTFWP{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII112FpTFWP().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max=0;
        int[][] lengths=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max=Math.max(dfs(matrix,lengths,i,j),max);
            }
        }
        return max;
    }
    public int dfs(int[][] matrix,int[][] lengths,int i,int j){
        if (lengths[i][j]!=0){
            return lengths[i][j];
        }
        int length=1;
        int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for (int i1 = 0; i1 < dir.length; i1++) {
            int r=i+dir[i1][0];
            int l=j+dir[i1][1];
            if (r>=0 && r<matrix.length && l>=0 && l<matrix[i].length && matrix[i][j]<matrix[r][l]){
                int path = dfs(matrix, lengths, r, l);
                length=Math.max(length,path+1);
            }
        }
        lengths[i][j]=length;
        return length;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
