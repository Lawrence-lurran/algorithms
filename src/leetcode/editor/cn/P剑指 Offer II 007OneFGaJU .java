//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 33 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：数组中和为 0 的三个数
@SuppressWarnings("all")
class P剑指OfferII007OneFGaJU{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII007OneFGaJU().new Solution();
        // TO TEST
        int[] nums=new int[]{0,0,0};
        solution.threeSum(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        if (len<3){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len-2; ) {

            int target=0-nums[i];
            int left=i+1;
            int right=len-1;
            while (left<right){
                List<Integer> temp=new ArrayList<>();
                int sum=nums[left]+nums[right];
                if (sum==target){
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    temp.add(nums[i]);
                    res.add(temp);
                    int oldLeft=nums[left];
                    while (nums[left]==oldLeft && left<right){
                        left++;
                    }
                }
                if (sum<target){
                    left++;
                }
                if (nums[left]+nums[right]>target){
                    right--;
                }
            }
            int old=nums[i];
            while (i<len && nums[i]==old ){
                i++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
