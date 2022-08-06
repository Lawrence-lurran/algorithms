//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
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
// Related Topics 数组 回溯 👍 894 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
@SuppressWarnings("all")
class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        int[] nums=new int[]{1,1,2};
        solution.permuteUnique(nums);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visted=new boolean[nums.length];
        backtrack(res,new ArrayList<>(),nums,visted);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> cur,int[] nums,boolean[] visted){
        if (cur.size()==nums.length){
//            if (!res.contains(cur)){
//            }
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && !visted[i-1]){
                continue;
            }
            if(!visted[i]){
                cur.add(nums[i]);
                visted[i]=true;
                backtrack(res,cur,nums,visted);
                cur.remove(cur.size()-1);
                visted[i]=false;
            }
        }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
