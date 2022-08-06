package interviews.meituan;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/12 4:42 下午
 */
public class Fourth {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int roomNum=scanner.nextInt();
        int m=scanner.nextInt();
        int[] booms=new int[m];
        for (int i = 0; i < m; i++) {
            booms[i]=scanner.nextInt();
        }
        int cur=1;
        int res=0;
        for (int i = 0; i < m; i++) {
            if (booms[i]==cur){
                cur=booms[i-1];
                res++;
            }
        }
        System.out.println(res);
    }
}
