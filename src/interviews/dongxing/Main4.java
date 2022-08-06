package interviews.dongxing;

import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/13 7:34 下午
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int res=0;
        int x=in.nextInt();
        int y=in.nextInt();
        res+=geshu(x,y);
        if (in.hasNext()){
            int t=in.nextInt();
            int i=in.nextInt();
            res+=geshu(t,i);
        }
        System.out.println(res);



    }
    public static boolean isSu(int x){
        for (int i = 2; i < x; i++) {
            if (x%i==0){
                return false;
            }
        }
        return true;
    }
    public static int geshu(int x,int y){
        int res=0;
        for (int i = x+1; i < y; i++) {
            if (isSu(i)){
                res++;
            }
        }
        return res;
    }
}
