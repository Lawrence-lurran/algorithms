package leetcode.editor.cn;



/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/1/30 12:50 上午
 */
public class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode(){
        children=new TrieNode[26];
    }
}
