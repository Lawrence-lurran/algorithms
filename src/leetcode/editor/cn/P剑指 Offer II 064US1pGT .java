//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单
//词存在于已构建的神奇字典中。 
//
// 实现 MagicDictionary 类： 
//
// 
// MagicDictionary() 初始化对象 
// void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字
//符串互不相同 
// bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得
//所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入
//inputs = ["MagicDictionary", "buildDict", "search", "search", "search", 
//"search"]
//inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], [
//"leetcoded"]]
//输出
//[null, null, false, true, false, false]
//
//解释
//MagicDictionary magicDictionary = new MagicDictionary();
//magicDictionary.buildDict(["hello", "leetcode"]);
//magicDictionary.search("hello"); // 返回 False
//magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//magicDictionary.search("hell"); // 返回 False
//magicDictionary.search("leetcoded"); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写英文字母组成 
// dictionary 中的所有字符串 互不相同 
// 1 <= searchWord.length <= 100 
// searchWord 仅由小写英文字母组成 
// buildDict 仅在 search 之前调用一次 
// 最多调用 100 次 search 
// 
// 
// 
// 
//
// 
//
// 注意：本题与主站 676 题相同： https://leetcode-cn.com/problems/implement-magic-
//dictionary/ 
// Related Topics 设计 字典树 哈希表 字符串 👍 9 👎 0

package leetcode.editor.cn;
//Java：神奇的字典
@SuppressWarnings("all")
class P剑指OfferII064US1pGT{
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new P剑指OfferII064US1pGT().new MagicDictionary();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MagicDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root=new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            insert(s);
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(root,searchWord,0,0);
    }

    public boolean dfs(TrieNode node,String word,int i,int edit){
        if (node==null){
            return false;
        }
        if (node.isWord && i==word.length() && edit==1){
            return true;
        }
        if (i<word.length() && edit<=1){
            boolean found=false;
            for (int j = 0; j < 26 && !found; j++) {
                int next= j==word.charAt(i)-'a' ? edit : edit+1;
                found=dfs(node.children[j],word,i+1,next );
            }
            return found;
        }
        return false;
    }
    public void insert(String s){
        TrieNode node=root;
        for (char c : s.toCharArray()) {
            if (node.children[c-'a']==null){
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.isWord=true;
    }

    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
