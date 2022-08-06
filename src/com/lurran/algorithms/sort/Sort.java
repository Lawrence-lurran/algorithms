package com.lurran.algorithms.sort;


/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/9 7:52 下午
 */
@SuppressWarnings("all")
public class Sort {
    /**
     * 选择排序
     * @param a 乱序数组
     */
    public static void selectionSort(Comparable[] a){
        for (int i = 0; i < a.length-1; i++) {
            int min=i;
            for (int j = i+1; j < a.length; j++) {
                boolean less = Util.less(a[min], a[j]);
                if (!less){
                    min=j;
                }
            }
            if (min!=i){
                Util.exch(a,min,i);
            }

        }
    }
    /**
     * 冒泡排序
     * @param a 乱序数组
     */
    public static void bubbleSort(Comparable[] a){
        boolean flag=false;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (Util.less(a[j+1],a[j])){
                    flag=true;
                    Util.exch(a,j,j+1);
                }
            }
            if (!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
    /**
     * 插入排序
     * @param a 乱序数组
     */
    public static void insertSort(Comparable[] a){
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0 && Util.less(a[j],a[j-1]); j--) {
                Util.exch(a,j,j-1);
            }
        }
    }
    /**
     * 希尔排序
     * @param a 乱序数组
     */
    public static void shellSort(Comparable[] a) {
        int gap=1;
        while (gap<a.length/3){
            gap=3*gap+1;
        }
        while (gap>=1){
            for (int i = gap; i < a.length; i++) {
                for (int j = i; j >= gap &&  Util.less(a[j],a[j-gap]) ; j-=gap) {
                    Util.exch(a,j,j-gap);
                }
            }
            gap=gap/3;
        }
    }

    /**
     * 快速排序
     * @param a 乱序数组
     * @param left  左指针
     * @param right 右指针
     */
    public static void quickSort(Comparable[] a,int left,int right) {
        int l=left;
        int r=right;
        Comparable pivot=a[(left+right)/2];

        while (l<r){
            while (Util.less(a[l],pivot)){
                l+=1;
            }
            while (Util.less(pivot,a[r])){
                r-=1;
            }
            if (l>=r){
                break;
            }
            Util.exch(a,l,r);
            if (a[l]==pivot){
                r-=1;
            }
            if (a[r]==pivot){
                l+=1;
            }
        }
        if (l==r){
            l+=1;
            r-=1;
        }
        if (left<r){
            quickSort(a,left,r);
        }
        if (right>l){
            quickSort(a,l,right);
        }
    }

    /**
     * 归并排序
     * @param a 乱序数组
     * @param left 左边有序序列的指针
     *
     * @param right 右边有序序列的指针
     * @param temp 中转数组
     */
    public static void mergeSort(Comparable[] a,int left,int right,Comparable[] temp){
        if (left<right){
            int mid=(left+right)/2;
            mergeSort(a,left,mid,temp);
            mergeSort(a,mid+1,right,temp);
            merge(a,left,mid,right,temp);
        }
    }
    public static void merge(Comparable[] a,int left,int mid,int right,Comparable[] temp){
        int i = left;
        int j = mid+1;
        //指向temp数组的当前指针
        int t = 0 ;
        while (i<=mid && j<=right){
            if (Util.less(a[i],a[j])){
                temp[t]=a[i];
                i+=1;
                t+=1;
            }else if (Util.less(a[j],a[i])){
                temp[t]=a[j];
                j+=1;
                t+=1;
            }
        }
        while ( i <= mid){
            temp[t]=a[i];
            t+=1;
            i+=1;

        }
        while ( j <= right){
            temp[t]=a[j];
            t+=1;
            j+=1;
        }

        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            a[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }

    }

    /**
     * 基数排序
     * @param a 乱序数组
     */
    public static void radixSort(Comparable[] a){
        int max=0;
        for (int i = 1; i < a.length; i++) {
            if (Util.less(a[max],a[i])){
                max=i;
            };
        }
        int maxLength=(a[max]+"").length();
        Comparable[][] bucket =new Comparable[10][a.length];
        int[] bucketElementCounts=new int[10];
        for (int i = 0, n=1;i < maxLength; i++,n *= 10) {

            for (int j = 0; j < a.length; j++) {
                int digitOfElement = ((int)a[j])/n%10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=a[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index=0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k]!=0){
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        a[index]=bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k]=0;
            }
        }
    }
}
