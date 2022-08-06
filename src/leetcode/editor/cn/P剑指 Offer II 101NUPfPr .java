//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
// Related Topics 数学 字符串 模拟 👍 22 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

@SuppressWarnings("all")
class P剑指OfferII101NUPfPr{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII101NUPfPr().new Solution();
        // TO TEST
        solution.canPartition(new int[]{23,13,11,7,6,5,5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int sum=0;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max= Math.max(max,nums[i]);
        }
        if (sum%2==1){
            return false;
        }
        int half=sum/2;
        if (max>half){
            return false;
        }else if (max==half){
            return true;
        }
        boolean[][] dp=new boolean[len][half+1];
        for (int i = 0; i < len; i++) {
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < half+1; j++) {
                if (j<nums[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[len-1][half];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
