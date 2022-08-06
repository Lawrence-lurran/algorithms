package leetcode.editor.cn;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/23 4:31 下午
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new LinkedList<>();
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            Trie trie = new Trie();
            for(int i =0;i<num;i++){
                String str = scanner.next();
                trie.insert(str);
            }
            String str1 = trie.getStr();
            list.add(str1);
        }
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    static class Trie{
        Trie[] children;
        boolean isEnd;
        String word;
        public Trie(){
            children = new Trie[26];
            isEnd = false;
            word = null;
        }
        public void insert(String word){
            Trie node = this;
            for(int i =0;i<word.length();i++){
                char c = word.charAt(i);
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new Trie();
                }
                node = node.children[c-'a'];
            }
            node.isEnd = true;
            node.word = word;
        }
        public String getStr(){
            Trie node = this;
            StringBuilder str = new StringBuilder();
            dfs(node,str);
            return str.toString();
        }
        public void dfs(Trie node,StringBuilder str){
            if(node.isEnd){
                str.append(node.word);
            }
            for(Trie child:node.children){
                if(child==null){
                    continue;
                }
                dfs(child,str);
            }
        }
    }
}
