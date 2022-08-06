package interviews.dongxing;

import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/13 7:07 下午
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (i%2==1){
                long num = Long.parseLong(string);
                String s1 = Long.toBinaryString(num);
                String s2 = new StringBuilder(s1).reverse().toString();
                strings[i]=s2;
                long integer = Long.valueOf(s2, 2);
                System.out.print(integer+" ");
            }else {
                System.out.print(string+" ");
            }

        }


    }
}
