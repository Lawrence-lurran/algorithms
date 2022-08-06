package interviews.baidu;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Main2   {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N = in.nextInt();
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < N; i++) {
            int curPrice=in.nextInt();
            int incr=in.nextInt();
            queue.add(new int[]{curPrice,incr});
        }
        int res=0;
        int num=0;
        for (int i = 0; num < N ; i++) {
            int[] lowPrice = queue.poll();
            res+=lowPrice[0];
            for (int[] ints : queue) {
                ints[0]=ints[0]+ints[1];
            }
            num++;
            if (i%2==1){
                num++;
            }
        }
        System.out.println(res);
    }
}
