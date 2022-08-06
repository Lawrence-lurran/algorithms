//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
// Related Topics 数组 回溯 👍 12 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：含有 k 个元素的组合
@SuppressWarnings("all")
class P剑指OfferII080UUsW3B{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII080UUsW3B().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        backTrack(n+1,1,new ArrayList<>(),res,k);
        return res;
    }
    public void backTrack(int n,int begin,List<Integer> temp,List<List<Integer>> res,int k){
        if (temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = begin; i < n; i++) {
            temp.add(i);
            backTrack(n,i+1,temp,res,k);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
