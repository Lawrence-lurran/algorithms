//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 👍 14 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：有效的回文
@SuppressWarnings("all")
class P剑指OfferII018XltzEq{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII018XltzEq().new Solution();
        // TO TEST
        System.out.println(solution.isPalindrome("0P"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int len=s.length();
        if (s==""){
            return true;
        }
        String s1 = s.toLowerCase();
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if ((s1.charAt(i)<='z' && s1.charAt(i) >='a') || (s1.charAt(i)<='9' && s1.charAt(i) >='0')){
                list.add(s1.charAt(i));
            }

        }
        int size=list.size();
        if (size==1){
            return true;
        }
        for (int i = 0; i < size/2; i++) {
            if (list.get(i)!=list.get(size-i-1)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
