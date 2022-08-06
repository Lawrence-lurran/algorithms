package leetcode.editor.cn;


import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/21 12:38 下午
 */
class Solution {
    private static Semaphore semaphore1=new Semaphore(1);
    private static Semaphore semaphore2=new Semaphore(0);
    private static volatile int num=0;

    private static LinkedList<Integer> stack=new LinkedList<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (num<100){
                    try {
                        semaphore1.acquire();
                        System.out.println(Thread.currentThread().getId()+"Thread1:"+num);
                        num++;
                        semaphore2.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (num<100){
                    try {
                        semaphore2.acquire();
                        System.out.println(Thread.currentThread().getId()+"Thread2:"+num);
                        num++;
                        semaphore1.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
    public void sort(int[] arr){
        quickSort(arr,0,arr.length-1);

    }
    public void quickSort(int[] arr,int start,int end){
        if (start<end){
            int piovt=partition(arr,start,end);
            quickSort(arr,piovt+1,end);
            quickSort(arr,start,piovt-1);
        }
    }
    public int partition(int[] arr,int start,int end){
        int random=new Random().nextInt(end-start+1)+start;
        swap(arr, random, end);
        int small=start-1;
        for (int i = 0; i < end; i++) {
            if (arr[i]<arr[end]){
                small++;
                swap(arr,i,small);
            }
        }
        small++;
        swap(arr,small,end);
        return small;
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
