//给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
//
// 
//
// 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-
//ii/ 
// Related Topics 字符串 动态规划 👍 13 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：最少回文分割
@SuppressWarnings("all")
class P剑指OfferII094OmKAoA{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII094OmKAoA().new Solution();
        // TO TEST
        System.out.println(solution.minCut("aabc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        int len=s.length();
        List<List<String>> res=new ArrayList<>();
        boolean[][] dp=new boolean[len][len];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j]=true;
            }
        }
        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                dp[i][j]=(s.charAt(i)==s.charAt(j))&&dp[i+1][j-1];
            }
        }
        int[] minC=new int[len];
        Arrays.fill(minC,Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            if (dp[0][i]){
                minC[i]=0;
            }else {
                for (int j = 0; j < i; j++) {
                    if (dp[j+1][i]){
                        minC[i]=Math.min(minC[i],minC[j]+1);
                    }
                }
            }
        }
        return minC[len-1];
    }
    public void dfs(List<List<String>> res,List<String> temp,String s,int start,boolean[][] dp){
        if (start==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]){
                temp.add(s.substring(start,i+1));
                dfs(res, temp, s, i+1, dp);
                temp.remove(temp.size()-1);
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
