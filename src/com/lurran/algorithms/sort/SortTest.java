package com.lurran.algorithms.sort;
import java.util.Random;
import org.junit.Test;


/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/9 7:56 下午
 */
public class SortTest {
    private static  Integer[] arr = new Integer[800000];
    private static  Comparable[] a={23,3,5,73,2,76,23,5,1000,23,45,75,12};


    static {
        for (int i = 0; i < 800000; i++) {
            double v = Math.random() * 800000;
            int round = (int)Math.round(v);
            arr[i]=round;
        }
    }
    @Test
    public void selectionSort() {
        long begin = System.currentTimeMillis();
        Sort.selectionSort(a);
        long end = System.currentTimeMillis();
        assert Util.isSorted(a);
        Util.show(a);
        System.out.println(end-begin);
    }

    @Test
    public void bubbleSort() {
        long begin = System.currentTimeMillis();
        Sort.bubbleSort(a);
        long end = System.currentTimeMillis();
        assert Util.isSorted(a);
        Util.show(a);
        System.out.println(end-begin);
    }
    @Test
    public void insertSort() {
        long begin = System.currentTimeMillis();
        Sort.insertSort(a);
        long end = System.currentTimeMillis();
        assert Util.isSorted(a);
        Util.show(a);
        System.out.println(end-begin);
    }
    @Test
    public void shellSort() {
        long begin = System.currentTimeMillis();
        Sort.shellSort(arr);
        long end = System.currentTimeMillis();
        assert Util.isSorted(arr);
        Util.show(a);
        System.out.println(end-begin);
    }

    @Test
    public void quickSort() {
        long begin = System.currentTimeMillis();
        Sort.quickSort(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        assert Util.isSorted(arr);
        Util.show(a);
        System.out.println(end-begin);
    }
    @Test
    public void mergeSort() {
        long begin = System.currentTimeMillis();
        Sort.mergeSort(arr,0,arr.length-1,new Comparable[arr.length]);
        long end = System.currentTimeMillis();
        assert Util.isSorted(arr);
        Util.show(a);
        System.out.println(end-begin);
    }
    @Test
    public void radixSort() {
        long begin = System.currentTimeMillis();
        Sort.radixSort(arr);
        long end = System.currentTimeMillis();
        assert Util.isSorted(arr);
        Util.show(a);
        System.out.println(end-begin);
    }
}
