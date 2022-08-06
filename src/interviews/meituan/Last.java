package interviews.meituan;

import java.util.*;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/12 5:31 下午
 */
public class Last {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] colors=new int[num];
        for (int i = 0; i < num; i++) {
            colors[i] = scanner.nextInt();
        }
        Map<Integer,List<Integer>> tree=new HashMap<>();
        for (int i = 0; i < num; i++) {
            int parent=scanner.nextInt();
            if (parent==0){
                continue;
            }
            tree.putIfAbsent(parent,new ArrayList<>());
            tree.get(parent).add(i+1);
        }
        //tree.getOrDefault()
        int sumWhit=0;
        int black=0;
        for (int i = 0; i < colors.length; i++) {
            if (!tree.containsKey(i+1)){
                if (colors[i]==1){
                    black++;
                }else {
                    sumWhit++;
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : tree.entrySet()) {
            int node = entry.getKey();
            if (colors[node-1]==0){
                for (Integer integer : tree.get(node)) {
                    if (colors[integer-1]==1){
                        sumWhit++;
                        break;
                    }
                }
            }else {
                int temp=0;
                for (Integer integer : tree.get(node)) {
                    if (colors[integer-1]==0){
                        temp++;
                    }
                }
                if (temp==2){
                    black++;
                }

            }
        }
        System.out.print(sumWhit+" ");
        System.out.print(black);
    }
}
