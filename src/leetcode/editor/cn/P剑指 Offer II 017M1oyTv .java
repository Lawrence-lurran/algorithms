//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 18 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：含有所有字符的最短字符串
@SuppressWarnings("all")
class P剑指OfferII017M1oyTv{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII017M1oyTv().new Solution();
        // TO TEST
        solution.minWindow("aa","aa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        String res="";
        int minLength=Integer.MAX_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        int lenduan=t.length();
        int lenchang=s.length();
        if (lenchang<lenduan){
            return res;
        }
        for (int i = 0; i < lenduan; i++) {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int size=map.size();
        int left=0;
        int right=0;
        while (left<lenchang ){
            while (right<lenchang){
                int count=0;
                if (map.containsKey(s.charAt(right))){
                    map.put(s.charAt(right),map.get(s.charAt(right))-1);
                    for (Integer value : map.values()) {
                        if (value<=0){
                            count++;
                        }
                    }
                }
                if (count==size){
                    map.put(s.charAt(right),map.get(s.charAt(right))+1);
                    break;
                }
                right++;
            }
            if (right>=lenchang){
                break;
            }
            if (right-left+1 <minLength) {
                minLength=right-left+1;
                res = s.substring(left, right+1);
            }
            if (map.containsKey(s.charAt(left))){
                map.put(s.charAt(left),map.get(s.charAt(left))+1);
                left++;
            }
            if (left>=lenchang){
                break;
            }
            while (left<lenchang && !map.containsKey(s.charAt(left))){
                left++;
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
