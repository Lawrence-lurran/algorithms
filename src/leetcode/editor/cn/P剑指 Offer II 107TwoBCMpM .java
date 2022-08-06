//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
//
// 
//
// 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/ 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 8 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：矩阵中的距离
@SuppressWarnings("all")
class P剑指OfferII107TwoBCMpM{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII107TwoBCMpM().new Solution();
        // TO TEST
        int[][] test=new int[][]{{0,1,1,0,1,0,0,1,1,1,0,1,0,0,1,0,0,1,0,1,1,1,0,0,1,0,1,1,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,1,0,1,1,0,0,1,1,1,0,1,1,1,0,1,0,1,1,0,0,1,0,1,0,0,1,0,1,1,0,1,1,1,0,0,0,1,0,0,1,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,1,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,1,0,1,0,1,1,0,1,0,0,0,0,0,1,0,1,1,0,1,1,1,1,0,1,0,0,1,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,1,0,1,1,0,1,0,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,0,0,1,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,0,1,0,1,0,1,0,1,0,0,1,1,0,0,0,1,0,1,0,1,1,0,1,0,1,0,0,1,1,0,0,1,0,0,1,0,0,0,1,1,0,1,1,1,0,0,0,1,1,0,0,0,1,1,0,1,0,0,0,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,0,1,1,0,0,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,1,0,0,0,0,0,1,1,0,1,1,0,1,1,1,1,0,1,0,1,0,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,0,1,0,0,1,1,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,1,1,0,0,1,1,1,1,0,0,0,1,0,0,1,1,0,1,1,1,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,1,1,1,0,1,1}
};
        solution.updateMatrix(test);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distance=new int[mat.length][mat[0].length];
        Queue<int[]> queue=new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int depth=-1;
        while (!queue.isEmpty()){
            int queueSize=queue.size();
            depth++;
            for (int z = 0; z < queueSize; z++) {
                int[] node=queue.poll();
                int curI=node[0];
                int curJ=node[1];
                if (distance[curI][curJ]!=0 ){
                    continue;
                }
                distance[curI][curJ]=depth;
                if (curI>0 && mat[curI-1][curJ]!=0){
                    queue.offer(new int[]{curI-1,curJ});
                }
                if (curI< mat.length-1 && mat[curI+1][curJ]!=0){
                    queue.offer(new int[]{curI+1,curJ});
                }
                if (curJ>0 && mat[curI][curJ-1]!=0){
                    queue.offer(new int[]{curI,curJ-1});
                }
                if (curJ< mat[0].length-1 && mat[curI][curJ+1]!=0){
                    queue.offer(new int[]{curI,curJ+1});
                }
            }
        }
        return distance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
