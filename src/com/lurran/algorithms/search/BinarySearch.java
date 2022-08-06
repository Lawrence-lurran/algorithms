package com.lurran.algorithms.search;

import java.util.ArrayList;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/28 5:40 下午
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] ={1,3,21,43,57,67,79,79,79,79,85,92,117,122,168,654,887,1000};
        int[] arr100=new int[100];
        for (int i = 0; i < 100; i++) {
            arr100[i]=i+1;
        }

        int index1 = insertValueSearch(arr100, 0, arr100.length-1 , 21);
        if (index1 == -1) {
            System.out.println("咩有查找到");
        }else {
            System.out.println("下表为："+index1);
        }


        int index = binarySearch(arr, 0, arr.length - 1, 21);
        if (index == -1) {
            System.out.println("咩有查找到");
        }else {
            System.out.println("下表为："+index);
        }

        ArrayList list = binarySearch2(arr, 0, arr.length - 1, 79);
        if (list.size() == 0) {
            System.out.println("咩有查找到");
        }else {
            System.out.println("下表为："+list);
        }
    }

    public static int binarySearch(int[] arr,int left,int right,int findValue){
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int midValue=arr[mid];

        if (findValue>midValue){
            return binarySearch(arr,mid+1,right,findValue);
        }else if (findValue<midValue){
            return binarySearch(arr,left,mid-1,findValue);
        }else {
            return mid;
        }

    }

    public static ArrayList binarySearch2(int[] arr, int left, int right, int findValue){
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        int midValue=arr[mid];

        if (findValue>midValue){
            return binarySearch2(arr,mid+1,right,findValue);
        }else if (findValue<midValue){
            return binarySearch2(arr,left,mid-1,findValue);
        }else {
            ArrayList<Integer> resIndexlist = new ArrayList<>();
            int temp=mid-1;
            while (true){
                if (temp<0 || arr[temp]!=findValue){
                    break;
                }
                resIndexlist.add(temp);
                temp-=1;
            }
            resIndexlist.add(mid);
            temp=mid+1;
            while (true){
                if (temp>arr.length-1 || arr[temp]!=findValue){
                    break;
                }
                resIndexlist.add(temp);
                temp+=1;
            }
            return resIndexlist;

        }

    }

    public static int insertValueSearch(int[] arr, int left, int right, int findValue){
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue=arr[mid];

        if (findValue>midValue){
            return insertValueSearch(arr,mid+1,right,findValue);
        }else if (findValue<midValue){
            return insertValueSearch(arr,left,mid-1,findValue);
        }else {
            return mid;
        }
    }
}
