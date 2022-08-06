//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 21 👎 0

package leetcode.editor.cn;
//Java：回文子字符串的个数
@SuppressWarnings("all")
class P剑指OfferII020A7VOhD{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII020A7VOhD().new Solution();
        // TO TEST
        solution.countSubstrings("fdsklf");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int len=s.length();
        char[] chars=s.toCharArray();
        int res=0;
        for (int i = 0; i < len; i++) {
            res+=check(chars,i,i);
            res+=check(chars,i,i+1);
        }
        return res;
    }


    public int check(char[] chars,int left,int right){
        int count=0;
        while (left>=0 && right<chars.length && chars[left]==chars[right]){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
