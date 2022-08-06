package interviews.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num = in.nextInt();
        int[][] geshu=new int[num][2];
        int[][] data=new int[num][];
        for (int i = 0; i < num; i++) {
            geshu[i][0]=in.nextInt();
            geshu[i][1]=in.nextInt();
            data[i]=new int[geshu[i][0]];
            for (int j = 0; j < geshu[i][0]; j++) {
                data[i][j]=in.nextInt();
            }
        }

        for (int i = 0; i < num; i++) {
            int[] res=new int[]{0};
            dfs(data[i],new ArrayList<>(),res,geshu[i][1],0);
            System.out.println(res[0]);
        }

    }
    public static void dfs(int[] nums, List<Integer> temp,int[] res,int len,int start){
        if (temp.size()==len ){
            int re=0;
            for (Integer integer : temp) {
                re+=integer;
            }
            if (re%2==0){
                res[0]++;
            }
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums,temp,res,len,i+1);
            temp.remove(temp.size()-1);
        }


    }
}
