//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
// Related Topics 数组 哈希表 前缀和 👍 32 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：0 和 1 个数相同的子数组
@SuppressWarnings("all")
class P剑指OfferII011A1NYOS{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII011A1NYOS().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        int len=nums.length;
        int sum=0;
        Map<Integer,Integer> sumToIndex=new HashMap<>();
        sumToIndex.put(0,0);
        int maxLength=0;
        for (int i = 0; i < len; i++) {
            sum+= nums[i]==0? -1:nums[i];
            if (sumToIndex.containsKey(sum)){
                maxLength=Math.max(maxLength,i-sumToIndex.get(sum)+1);
            }else {
                sumToIndex.put(sum,i);
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
