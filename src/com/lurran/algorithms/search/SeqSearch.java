package com.lurran.algorithms.search;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/28 5:29 下午
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1, 9, 4, -2, 3, 56};
        int index = seqSearch(arr, 1);
        if (index == -1) {
            System.out.println("咩有查找到");
        }else {
            System.out.println("下表为："+index);
        }
    }

    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }

}
