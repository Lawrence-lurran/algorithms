//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,100]
//输出：100
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 
//
// 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/ 
// Related Topics 位运算 数组 👍 39 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：只出现一次的数字
@SuppressWarnings("all")
class P剑指OfferII004WGki4K{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII004WGki4K().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i+2<nums.length && nums[i]==nums[i+2]){
                i+=2;
            }else {
                return nums[i];
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
