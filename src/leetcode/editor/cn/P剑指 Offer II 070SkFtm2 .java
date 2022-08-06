//给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？ 
//
// 
//
// 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-
//array/ 
// Related Topics 数组 二分查找 👍 14 👎 0

package leetcode.editor.cn;
//Java：排序数组中只出现一次的数字
@SuppressWarnings("all")
class P剑指OfferII070SkFtm2{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII070SkFtm2().new Solution();
        // TO TEST
        solution.singleNonDuplicate(new int[]{1,1,2});


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int singleNonDuplicate(int[] nums) {
//        int left=0;
//        int right=nums.length-1;
//        while (left<right){
//            int mid=left+((right-left)>>1);
//            if (nums[mid]==nums[mid^1]){
//                left=mid+1;
//            }else
//                right=mid;
//        }
//        return nums[left];
//    }
        public int singleNonDuplicate(int[] nums) {
            int left=0;
            int right=nums.length-1;
            while (left<right){
                int mid=left+((right-left)>>1);
                mid-=mid&1;
                if (nums[mid]==nums[mid+1]){
                    left=mid+2;
                }else
                    right=mid;
            }
            return nums[left];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
