package interviews.dongxing;

import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/13 6:58 下午
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String date=in.next();
        String[] split = date.split("-");
        int mouth=Integer.parseInt(split[1]);
        int day=Integer.parseInt(split[2]);
        int res=day;
        int year=Integer.parseInt(split[0]);
        for (int i = 2; i <= mouth; i++) {
            int n=i-1;
            if (n %2==1){
                if (n <=7){
                    res+=31;
                }else {
                    res+=30;
                }
            }else if (n ==2){
                if (year%4==0){
                    res+=29;
                }else {

                    res+=28;
                }
            }else {
                if (n <=7){
                    res+=30;
                }else {
                    res+=31;
                }
            }
        }
        System.out.println(res);

    }
}
