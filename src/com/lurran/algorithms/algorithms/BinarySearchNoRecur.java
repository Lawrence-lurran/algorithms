package com.lurran.algorithms.algorithms;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/10/8 9:20 下午
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,7,12,16,26,74,100};
        System.out.println(binarySearch(arr, 4));
    }
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (target<arr[mid]) {
                right = mid - 1;
            }else if (target>arr[mid]){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
