//给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "a"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// 
//
// 注意：本题与主站 242 题相似（字母异位词定义不同）：https://leetcode-cn.com/problems/valid-anagram/ 
// Related Topics 哈希表 字符串 排序 👍 12 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：有效的变位词
@SuppressWarnings("all")
class P剑指OfferII032DKk3P7{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII032DKk3P7().new Solution();
        // TO TEST
        solution.isAnagram("ab","ab");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> latters=new HashMap<>();
        int lenS=s.length();
        int lenT=t.length();

        if (lenS!=lenT || s.equals(t)){
            return false;
        }
        for (int i = 0; i < lenS; i++) {
            latters.put(s.charAt(i),latters.getOrDefault(s.charAt(i),0)+1);
            latters.put(t.charAt(i),latters.getOrDefault(t.charAt(i),0)-1);
        }
        for (Map.Entry<Character, Integer> entry : latters.entrySet()) {
            if (entry.getValue()!=0){
                return false;
            }

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
