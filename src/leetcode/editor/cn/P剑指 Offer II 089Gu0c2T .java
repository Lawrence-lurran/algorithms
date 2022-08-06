//一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被
//小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：nums = [2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// 
//
// 注意：本题与主站 198 题相同： https://leetcode-cn.com/problems/house-robber/ 
// Related Topics 数组 动态规划 👍 12 👎 0

package leetcode.editor.cn;
//Java：房屋偷盗
@SuppressWarnings("all")
class P剑指OfferII089Gu0c2T{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII089Gu0c2T().new Solution();
        // TO TEST
        solution.rob(new int[]{1,2,3,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if (len==1){
            return nums[0];
        }
        if (len==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp=new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        dp[2]=dp[0]+nums[2];
        int maxI2=Math.max(dp[0],dp[1]);
        for (int i = 3; i < len; i++) {
            dp[i]=nums[i]+maxI2;
            maxI2=Math.max(maxI2,dp[i-1]);
        }
        return Math.max(dp[len-1],dp[len-2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
