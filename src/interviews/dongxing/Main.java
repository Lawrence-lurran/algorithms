package interviews.dongxing;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int x=in.nextInt();
        x=x<0?x+1:x-1;
        int y=in.nextInt();
        y=y<0?y+1:y-1;
        int res=0;
        for (int i = x; i < y; i++) {
            if (i%2==1){
                res++;
            }
        }
        System.out.println(res);
    }
}
