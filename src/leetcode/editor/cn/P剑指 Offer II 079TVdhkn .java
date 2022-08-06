//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// 
//
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
// Related Topics 位运算 数组 回溯 👍 14 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：所有子集
@SuppressWarnings("all")
class P剑指OfferII079TVdhkn{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII079TVdhkn().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backTrack(nums,res,new ArrayList<>(),0);
        return res;
    }
    public void backTrack(int[] nums,List<List<Integer>> res,List<Integer> temp,int begin){
        res.add(new ArrayList<>(temp));
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(nums,res,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
