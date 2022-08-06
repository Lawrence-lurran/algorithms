//给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵
//树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。 
//
// 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若
//干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。 
//
// 请你返回有 最高得分 节点的 数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：parents = [-1,2,0,2,0]
//输出：3
//解释：
//- 节点 0 的分数为：3 * 1 = 3
//- 节点 1 的分数为：4 = 4
//- 节点 2 的分数为：1 * 1 * 2 = 2
//- 节点 3 的分数为：4 = 4
//- 节点 4 的分数为：4 = 4
//最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
// 
//
// 示例 2： 
//
// 
//
// 输入：parents = [-1,2,0]
//输出：2
//解释：
//- 节点 0 的分数为：2 = 2
//- 节点 1 的分数为：2 = 2
//- 节点 2 的分数为：1 * 1 = 1
//最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
// 
//
// 
//
// 提示： 
//
// 
// n == parents.length 
// 2 <= n <= 10⁵ 
// parents[0] == -1 
// 对于 i != 0 ，有 0 <= parents[i] <= n - 1 
// parents 表示一棵二叉树。 
// 
// Related Topics 树 深度优先搜索 数组 二叉树 👍 81 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：统计最高分的节点数目
@SuppressWarnings("all")
class P2049CountNodesWithTheHighestScore{
    public static void main(String[] args) {
        Solution solution = new P2049CountNodesWithTheHighestScore().new Solution();
        // TO TEST
        solution.countHighestScoreNodes(new int[]{-1,9,3,0,13,2,10,2,18,16,18,5,9,3,4,13,0,12,16});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int size;
        long max=0;
        Map<Long,Integer> scoresMap = new HashMap<>();
        public int countHighestScoreNodes(int[] parents) {
            int num = parents.length;
            size = parents.length;
            List<List<Integer>> tree = new ArrayList<>();
            int[] subTreeNum = new int[num];
            for (int i =0;i<num;i++){
                tree.add(new ArrayList<>());
            }
            for (int i = 1;i<num;i++){
                tree.get(parents[i]).add(i);
            }
            dfs(tree,0);
            int result = scoresMap.get(max);
            return result;
        }
        public int dfs(List<List<Integer>> tree,int cur){
            int num = 1;
            long score = 1;
            int n = size-1;
            for (int child :tree.get(cur)){
                int childNum =dfs(tree,child);
                score*=childNum;
                n-=childNum;
                num+=childNum;
            }
            if (cur!=0){
                score*=n;
            }
            max = Math.max(max,score);
            scoresMap.put(score,scoresMap.getOrDefault(score,0)+1);
            return num;
        }
//        public int countHighestScoreNodes(int[] parents) {
//            Map<Integer,Integer> map=new HashMap<>();
//            Map<Integer, List<Integer>> childrens=new HashMap<>();
//            for(int i=1;i<parents.length;i++){
//                map.put(parents[i],map.getOrDefault(parents[i],1)+1);
//                childrens.putIfAbsent(parents[i],new ArrayList<>());
//                childrens.get(parents[i]).add(i);
//            }
//            for (Integer integer : map.keySet()) {
//                for (int i = 0; i < childrens.get(integer).size(); i++) {
//                    map.put(integer,map.get(integer)+map.getOrDefault(childrens.get(integer).get(i),1)-1);
//                }
//            }
//            map.put(0,parents.length);
//            Map<Integer,Integer> res=new HashMap<>();
//            for(int j=0;j<parents.length;j++){
//                if(j==0){
//                    int temp=1;
//                    List<Integer> list = childrens.get(j);
//                    int size= list.size();
//                    for(int k=0;k<size;k++){
//                        temp=temp*map.getOrDefault(list.get(k),1);
//                    }
//                    res.put(temp,1);
//                }else{
//                    int temp=1;
//                    if (childrens.containsKey(j)){
//                        List<Integer> list = childrens.get(j);
//                        int size=list.size();
//                        for(int k=0;k<size;k++){
//                            temp=temp*map.getOrDefault(list.get(k),1);
//                        }
//                    }
//                    int pa=map.get(0);
//                    pa-=map.getOrDefault(j,1);
//                    temp*=pa;
//                    res.put(temp,res.getOrDefault(temp,0)+1);
//                }
//            }
//            int max=0;
//            for (Integer integer : res.keySet()) {
//                max=Math.max(integer,max);
//            }
//            return max==0?0:res.get(max);
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
