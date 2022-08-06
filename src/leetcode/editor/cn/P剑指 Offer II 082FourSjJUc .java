//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
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
//输入: candidates = [2,5,2,1,2], target = 5,
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
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 👍 14 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：含有重复元素集合的组合
@SuppressWarnings("all")
class P剑指OfferII082FourSjJUc{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII082FourSjJUc().new Solution();
        // TO TEST
        solution.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,target,res,new ArrayList<>(),0);
        return res;
    }
    public void backTrack(int[] candidates,int target,List<List<Integer>> res,List<Integer> temp,int begin){
        if (target<0){
            return;
        }
        if (target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target-candidates[i]<0){
                break;
            }
            if (i>begin && candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            backTrack(candidates,target-candidates[i],res,temp,i+1);
            temp.remove(temp.size()-1);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
