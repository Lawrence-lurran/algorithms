//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 799 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：组合
@SuppressWarnings("all")
class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,new ArrayList<Integer>(),n,k,0);
        return res;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> cur,int n,int k,int begin){
        if(cur.size()==k){
            res.add(new ArrayList<>(cur));
        }
        for (int i = begin; i < n; i++) {
            cur.add(i+1);
            backtrack(res, cur, n, k,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
