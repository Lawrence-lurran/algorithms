//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 16 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
class P剑指OfferII086M99OJA{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII086M99OJA().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[][] partition(String s) {
        List<List<String>> res=new ArrayList<>();
        backTrack(s,0,new ArrayList<>(),res);
        String[][] ans=new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i]=new String[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                ans[i][j]=res.get(i).get(j);
            }
        }
        return ans;
    }
    public void backTrack(String str, int start, List<String> temp,List<List<String>> res){
        if (start==str.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isP(str,start,i)){
                temp.add(str.substring(start,i+1));
                backTrack(str,i+1,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isP(String s,int start,int end){
        while (start<end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
