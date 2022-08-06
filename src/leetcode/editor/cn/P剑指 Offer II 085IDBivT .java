//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 👍 16 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：生成匹配的括号
@SuppressWarnings("all")
class P剑指OfferII085IDBivT{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII085IDBivT().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,new StringBuffer(),0,0,n);
        return res;
    }
    public void backtrack(List<String> res,StringBuffer sb,int open,int close,int max){
        if (sb.length()==2*max){
            res.add(sb.toString());
            return;
        }

        if (open<max){
            sb.append("(");
            backtrack(res,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if (close<open){
            sb.append(")");
            backtrack(res,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
