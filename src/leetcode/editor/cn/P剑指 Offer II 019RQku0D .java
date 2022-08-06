//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 👍 19 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：最多删除一个字符得到回文
@SuppressWarnings("all")
class P剑指OfferII019RQku0D{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII019RQku0D().new Solution();
        // TO TEST
        solution.validPalindrome("beeee");

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int len=s.length();
        if (check(s)){
            return true;
        }
        int left=0;
        int right=len-1;
        while (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
        }
        if (check(s.substring(left,right))){
            return true;
        }
        if (check(s.substring(left+1,right+1))){
            return true;
        }
        return false;


    }
    public boolean check(String s){
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
