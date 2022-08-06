package com.lurran.algorithms.sort;

import edu.princeton.cs.algs4.StdOut;

/**
 * Description:
 *  排序算法
 * @author lurran
 * @data Created on 2021/9/9 7:20 下午
 */
public class Util {
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void show(Comparable[] a){
        for (Comparable comparable : a) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }


}
