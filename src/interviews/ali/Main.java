package interviews.ali;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/14 6:43 下午
 */
public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String subStr=str.substring(2);
        long num = Long.parseLong(subStr, 16);
        int res=0;
        while (num!=0){
            res++;
            num=num & (num-1);
        }


        System.out.println(res);


    }
}
