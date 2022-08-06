//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。 
//
// 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/ 
// Related Topics 哈希表 字符串 排序 👍 14 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：变位词组
@SuppressWarnings("all")
class P剑指OfferII033Sfvd7V{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII033Sfvd7V().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            int[] count=new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)-'a']++;
            }
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
                sb.append((char) i+'a');
            }

            List<String> list=map.getOrDefault(sb.toString(),new ArrayList<String>());
            list.add(str);
            map.put(sb.toString(),list);

        }
        return new ArrayList<>(map.values());
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
