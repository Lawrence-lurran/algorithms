package com.lurran.algorithms.algorithms.dac;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/10/8 10:03 下午
 */
public class HanoiTower {
    static int count=0;
    public static void main(String[] args) {
        hanoiTower(5,'a','b','c');
        System.out.println(count);
    }
    public static void hanoiTower(int num, char a, char b, char c){
        if (num ==1){
            count++;
            System.out.println("第1个盘从 "+a+"->"+c);
        }else {
            hanoiTower(num -1,a,c,b);
            count++;
            System.out.println("第"+ num+"个盘从 "+a+"->"+c);
            hanoiTower(num -1,b,a,c);
        }
    }
}
