//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-
//string/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 10 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：字符串中的所有变位词
@SuppressWarnings("all")
class P剑指OfferII015VabMRr{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII015VabMRr().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        if (m>n){
            return res;
        }
        int[] ans1=new int[26];
        int[] ans2=new int[26];
        for (int i = 0; i < m; i++) {
            ans1[s.charAt(i)-'a']++;
            ans2[p.charAt(i)-'a']++;

        }
        if (Arrays.equals(ans1,ans2)){
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            ans1[s.charAt(i)-'a']++;
            ans1[s.charAt(i-m)-'a']--;
            if (Arrays.equals(ans1,ans2)){
                res.add(i-m+1);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
