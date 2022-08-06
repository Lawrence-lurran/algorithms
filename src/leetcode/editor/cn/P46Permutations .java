//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
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
// Related Topics 数组 回溯 👍 1696 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
@SuppressWarnings("all")
class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] visted=new boolean[nums.length];
        backtrack(res,new ArrayList<>(),nums,visted);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> cur,int[] nums,boolean[] visted){
        if (cur.size()==nums.length){
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
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
