package com.lurran.algorithms.sort;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/9 7:52 下午
 */
public class Sort1 {
    public static void selectionSort(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {
            int min=i;
            for (int j = i+1; j < a.length; j++) {
                if (Util.less(a[j],a[min])){
                    min=j;
                }
            }
            Util.exch(a,min,i);
        }
    }

    public static void insertSort(Comparable[] a){

    }
    public static void bubbleSort(Comparable[] a){

    }
}
