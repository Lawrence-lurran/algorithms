//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// 
//
// 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-
//k/ 
// Related Topics 数组 滑动窗口 👍 35 👎 0

package leetcode.editor.cn;
//Java：乘积小于 K 的子数组
@SuppressWarnings("all")
class P剑指OfferII009ZVAVXX{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII009ZVAVXX().new Solution();
        // TO TEST
        int[] nums=new int[]{10,5,2,6};
        solution.numSubarrayProductLessThanK(nums,100);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long mutil=1;
        int left=0;
        int res=0;
        int len=nums.length;
        for (int right = 0; right < len; right++) {
            mutil*=nums[right];
            while (left<=right && mutil>=k){
                mutil/=nums[left];
                left++;

            }
            res += right>=left ? right-left+1 : 0;

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
