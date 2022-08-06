package leetcode.editor.cn;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/1/30 12:53 上午
 */
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
