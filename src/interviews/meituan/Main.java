package interviews.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/12 3:40 下午
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= nums.get(i);
            sums.add(sum);
        }
        int res = 0;
        for (int i = 0; i < sums.size(); i++) {
            if (sums.get(i) > 0) {
                res++;
            }
            for (int j = 0; j < i; j++) {
                if (sums.get(i) / sums.get(j) > 0) {
                    res++;
                }
            }
        }
        System.out.println(nums);
        System.out.println(sums);
        System.out.println(res);
    }
}






//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            int num=scanner.nextInt();
//            boolean check = check(num);
//            if (check){
//                System.out.println("yes");
//            }else {
//                System.out.println("no");
//            }
//        }
//    }
//    public static boolean check(int num){
//        if (num%11==0){
//            return true;
//        }
//        String strNum=num+"";
//        int count=0;
//        for (int i = 0; i < strNum.length(); i++) {
//            if (strNum.charAt(i)=='1'){
//                count++;
//            }
//            if (count>=2){
//                return true;
//            }
//        }
//        return false;
//    }

