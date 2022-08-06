//给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语
//的小写字母。如果没有不包含相同字符的一对字符串，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。 
//
// 示例 2: 
//
// 
//输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: words = ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-
//lengths/ 
// Related Topics 位运算 数组 字符串 👍 33 👎 0

package leetcode.editor.cn;
//Java：单词长度的最大乘
@SuppressWarnings("all")
class P剑指OfferII005AseY1I{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII005AseY1I().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int len=words.length;
        boolean[][] flag=new boolean[len][26];
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                flag[i][c-'a']=true;
            }
        }

        int res=0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flag[i][k]&&flag[j][k]){
                        break;
                    }
                }
                if (k==26){
                    int twoenght=words[i].length()*words[j].length();
                    res=Math.max(res,twoenght);
                }
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
