package com.lurran.algorithms.dataStructrue;

import java.util.Arrays;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/17 7:51 下午
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue() {
    }

    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        //指向队列头部，分析出 front 是指向队列头的前一个位置
        front=-1;
        //指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        rear=-1;
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public void enqueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能添加数据");
            return;
        }
        rear++;
        arr[rear]=n;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];

    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        System.out.println(Arrays.toString(arr));
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front+1];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(10);
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.isFull());
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(4);
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.isFull());
        System.out.println(arrayQueue.dequeue());
        arrayQueue.showQueue();
        System.out.println(arrayQueue.headQueue());

    }

}
