package com.lurran.algorithms.dataStructrue;


/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/18 5:35 下午
 */
public class CircleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue() {
    }

    public CircleArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        // front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
        front=0;
        //rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
        rear=-0;
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public void enqueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能添加数据");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        int value =arr[front];
        front = (front + 1) % maxSize;
        return value;

    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.println(arr[i%maxSize]);
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
