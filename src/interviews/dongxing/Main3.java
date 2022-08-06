package interviews.dongxing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/13 7:21 下午
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String next = in.next();
        char[] chars = next.toCharArray();
        Set<String> set=new HashSet<>();
        int left=0;
        int res=0;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <= chars.length; i++) {

            if (i==chars.length){
                String s=sb.toString();
                if (set.contains(s)){

                }else {
                    res+=sb.length();
                    set.add(s);

                }
                break;
            }
            if (chars[left]==chars[i]){
                sb.append(chars[i]);
            }else {
                String s=sb.toString();
                if (set.contains(s)){

                }else {
                    res+=sb.length();
                    set.add(s);

                }
                left=i;
                i=i-1;
                sb=new StringBuilder();
            }
        }
        System.out.println(res);
    }
}
