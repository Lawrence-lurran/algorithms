//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 769 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
@SuppressWarnings("all")
class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res,candidates,target,new ArrayList<Integer>(),0);
        return res;
    }
    public void backtrack(List<List<Integer>> res,int[] candidates,int target,List<Integer> cur,int begin){
        if (target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<Integer>(cur));
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i>begin && candidates[i]==candidates[i-1]){
                continue;
            }
            cur.add(candidates[i]);
            backtrack(res,candidates,target-candidates[i],cur,i+1);
            cur.remove(cur.size()-1);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
