package com.lurran.algorithms.dataStructrue;

import java.util.Iterator;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/16 10:14 下午
 */
@SuppressWarnings("all")
public class ResizingArrayQueue <Item> implements Iterable<Item>{
    private Item[] a=(Item[]) new Object[1];
    private int N=0;
    private int head=0;

    public boolean isEmpty(){
        return N-head==0;
    }

    public int size(){
        return N-head;
    }
    private void resize(int max){
        Item[] temp=(Item[]) new Object[max];
        for (int i = head; i < N; i++) {
            temp[i]=a[i];
        }
        a=temp;
    }

    public void enqueue(Item item){
        if (N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }

    public Item dequeue(){
        Item item=a[head];
        a[head]=null;
        head++;
        if (N>0 && N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> resizingArrayQueue=new ResizingArrayQueue<>();
        resizingArrayQueue.enqueue("第一个");
        resizingArrayQueue.enqueue("第二个");
        System.out.println(resizingArrayQueue.size());
        String dequeue = resizingArrayQueue.dequeue();
        System.out.println(dequeue);
        System.out.println(resizingArrayQueue.dequeue());
        System.out.println(resizingArrayQueue.size());
    }
}
