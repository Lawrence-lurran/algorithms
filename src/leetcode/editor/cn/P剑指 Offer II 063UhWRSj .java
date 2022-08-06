//在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟
//随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 需要输出替换之后的句子。 
//
// 
//
// 示例 1： 
//
// 
//输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by 
//the battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 2： 
//
// 
//输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
// 
//
// 示例 3： 
//
// 
//输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa 
//aaa aaaaaa bbb baba ababa"
//输出："a a a a a a a a bbb baba a"
// 
//
// 示例 4： 
//
// 
//输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was 
//rattled by the battery"
//输出："the cat was rat by the bat"
// 
//
// 示例 5： 
//
// 
//输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is 
//accepted"
//输出："it is ab that this solution is ac"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写字母组成。 
// 1 <= sentence.length <= 10^6 
// sentence 仅由小写字母和空格组成。 
// sentence 中单词的总量在范围 [1, 1000] 内。 
// sentence 中每个单词的长度在范围 [1, 1000] 内。 
// sentence 中单词之间由一个空格隔开。 
// sentence 没有前导或尾随空格。 
// 
//
// 
//
// 注意：本题与主站 648 题相同： https://leetcode-cn.com/problems/replace-words/ 
// Related Topics 字典树 数组 哈希表 字符串 👍 12 👎 0

package leetcode.editor.cn;

import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;
import java.util.List;

//Java：替换单词
@SuppressWarnings("all")
class P剑指OfferII063UhWRSj{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII063UhWRSj().new Solution();
        // TO TEST
        List<String> list=new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        solution.replaceWords(list,"the cattle was rattled by the battery");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=new Trie();
        for (int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i));
        }
        String[] strings=sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (trie.search(strings[i])){
                strings[i]=trie.replace(strings[i]);
            }
        }
        StringBuffer sb=new StringBuffer();
        for (String string : strings) {
            sb.append(string).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
        public class TrieNode {
            TrieNode[] children;
            boolean isWord;
            public TrieNode(){
                children=new TrieNode[26];
            }
        }
        public class Trie {
            class TrieNode{
                TrieNode[] children;
                boolean isWord;
                public TrieNode(){
                    children=new TrieNode[26];
                }
            }
            private TrieNode root;
            /** Initialize your data structure here. */
            public Trie() {
                root=new TrieNode();
            }

            /** Inserts a word into the trie. */
            public void insert(String word) {
                TrieNode node=root;
                for (char c : word.toCharArray()) {
                    if (node.children[c-'a']==null){
                        node.children[c-'a']=new TrieNode();
                    }
                    node=node.children[c-'a'];
                }
                node.isWord=true;
            }

            /** Returns if the word is in the trie. */
            public boolean search(String word) {
                TrieNode node=root;
                for (char c : word.toCharArray()) {
                    if (node.isWord){
                        return true;
                    }
                    if (node.children[c-'a']==null){
                        return false;
                    }
                    node=node.children[c-'a'];
                }
                return node.isWord;
            }

            /** Returns if there is any word in the trie that starts with the given prefix. */
            public boolean startsWith(String prefix) {
                TrieNode node=root;
                for (char c : prefix.toCharArray()) {
                    if (node.children[c-'a']==null){
                        return false;
                    }
                    node=node.children[c-'a'];
                }
                return true;
            }
            public String replace(String s) {
                TrieNode node=root;
                StringBuffer sb=new StringBuffer();
                for (int i = 0; i < s.toCharArray().length; i++) {
                    if (node.isWord || node.children[s.charAt(i)-'a']==null){
                        break;
                    }
                    node=node.children[s.charAt(i)-'a'];
                    sb.append(s.charAt(i));

                }
                return sb.toString();
            }
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}
