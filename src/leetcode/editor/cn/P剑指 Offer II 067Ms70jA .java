//给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,4]
//输出：6
// 
//
// 示例 4： 
//
// 
//输入：nums = [8,10,2]
//输出：10
// 
//
// 示例 5： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
// 
// 
//
// 
//
// 进阶：你可以在 O(n) 的时间解决这个问题吗？ 
//
// 
//
// 注意：本题与主站 421 题相同： https://leetcode-cn.com/problems/maximum-xor-of-two-
//numbers-in-an-array/ 
// Related Topics 位运算 字典树 数组 哈希表 👍 21 👎 0

package leetcode.editor.cn;
//Java：最大的异或
@SuppressWarnings("all")
class P剑指OfferII067Ms70jA{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII067Ms70jA().new Solution();
        // TO TEST
        solution.findMaximumXOR(new int[]{2,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class Tire{
            public Tire right=null;
            public Tire left=null;
        }
        public Tire root=new Tire();

    public int findMaximumXOR(int[] nums) {
        int max=0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i-1]);
            int temp=check(nums[i]);
            max=max>temp?max:temp;
        }
        return max;
    }
    public void add(int num){
        Tire node=root;
        for (int i = 30; i >= 0; i--) {
            int bit=(num>>i)&1;
            if (bit==0){
                if (node.right==null){
                    node.right=new Tire();
                }
                node=node.right;
            }else {
                if (node.left==null){
                    node.left=new Tire();
                }
                node=node.left;
            }
        }
    }
    public int check(int num){
        Tire node=root;
        int x=0;
        for (int i = 30; i >= 0; i--) {
            int bit=(num>>i)&1;
            if (bit==0){
                if (node.left==null){
                    node=node.right;
                    x*=2;
                }else {
                    node=node.left;
                    x=x*2+1;
                }
            }else {
                if (node.right==null){
                    node=node.left;
                    x*=2;
                }else {
                    node=node.right;
                    x=x*2+1;
                }
            }
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
