//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// 
//
// 注意：本题与主站 209 题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/ 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 31 👎 0

package leetcode.editor.cn;
//Java：和大于等于 target 的最短子数组
@SuppressWarnings("all")
class P剑指OfferII008TwoVG8Kg{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII008TwoVG8Kg().new Solution();
        // TO TEST
        solution.minSubArrayLen(15,new int[]{1,2,3,4,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
            while (sum>=target && left<=i){
                res=Math.min(res,i-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
