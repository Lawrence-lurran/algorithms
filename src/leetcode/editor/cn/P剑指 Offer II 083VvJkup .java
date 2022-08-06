//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 👍 11 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：没有重复元素集合的全排列
@SuppressWarnings("all")
class P剑指OfferII083VvJkup{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII083VvJkup().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backTrack(nums,res,new ArrayList<>());
        return res;
    }
    public void backTrack(int[] nums,List<List<Integer>> res,List<Integer> temp){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            backTrack(nums, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
