//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 注意：本题与主站 115 题相同： https://leetcode-cn.com/problems/distinct-subsequences/ 
// Related Topics 字符串 动态规划 👍 8 👎 0

package leetcode.editor.cn;
//Java：子序列的数目
@SuppressWarnings("all")
class P剑指OfferII097Two1dk04{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII097Two1dk04().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int[][] dp=new int[len1+1][len2+1];
        dp[0][0]=1;
        for (int i = 0; i < len1+1; i++) {
            dp[i][0]=1;
        }
        for (int j = 1; j < len2+1; j++) {
            dp[0][j]=0;
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j<=i && j < len2; j++) {
                char char1=s.charAt(i);
                char char2=t.charAt(j);
                if (char1==char2){
                    dp[i+1][j+1]=dp[i][j]+dp[i][j+1];
                }else {
                    dp[i+1][j+1]=dp[i][j+1];
                }
            }
        }
        return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
