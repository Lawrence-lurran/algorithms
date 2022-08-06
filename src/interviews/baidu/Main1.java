package interviews.baidu;

import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String next = in.next();
        char[] chars = next.toCharArray();
        int[] direction=new int[]{0,0};
        for (int i = 0; i < chars.length; i++) {
            char direct = chars[i];
            if (direct =='L'){
                direction[0]--;
            }else if (direct =='R'){
                direction[0]++;
            }else if (direct =='U'){
                direction[1]++;
            }else if (direct =='D'){
                direction[1]--;
            }
        }
        System.out.print("("+direction[0]+","+direction[1]+")");
    }
}
