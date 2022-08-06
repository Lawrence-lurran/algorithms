package interviews.ali;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/14 7:28 下午
 */
public class Sec {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n= sc.nextInt();
//        int m=sc.nextInt();
        int[][] graph=new int[][]{{0,1,0,0},{1,0,1,0}};
        boolean[] hang=new boolean[2];
        boolean[] lie=new boolean[4];
        Queue<int[]> queue=new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                //graph[i][j]=sc.nextInt();
                if (graph[i][j]==0){
                    queue.add(new int[]{i,j});
                }
                if (graph[i][j]==1){
                    hang[i]=true;
                    lie[j]=true;
                }
            }
        }
        int res=0;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int hangtemp=poll[0];
            int lietemp=poll[1];
            if (hang[hangtemp]==true){
                res++;
            }
            if (lie[lietemp]==true){
                res++;
            }

        }
        System.out.println(res);
    }
}
