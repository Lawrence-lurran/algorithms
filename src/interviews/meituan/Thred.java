package interviews.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/12 4:27 下午
 */
public class Thred {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int food1=scanner.nextInt();
            int food2=scanner.nextInt();
            if (!map.containsKey(food1) && !map.containsKey(food2) && food1<=m && food2<=m){
                map.put(food1,i);
                map.put(food2,i);
                res++;
            }
        }
        System.out.println(res);
    }
}
