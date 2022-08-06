//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 👍 11 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：含有重复元素集合的全排列
@SuppressWarnings("all")
class P剑指OfferII084SevenP8L0Z{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII084SevenP8L0Z().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backTrack(nums,res,new ArrayList<>(),used);
        return res;
    }
    public void backTrack(int[] nums,List<List<Integer>> res,List<Integer> temp,boolean[] used){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                if (i>0 && nums[i]==nums[i-1] && !used[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                used[i]=true;
                backTrack(nums, res, temp, used);
                temp.remove(temp.size()-1);
                used[i]=false;
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
