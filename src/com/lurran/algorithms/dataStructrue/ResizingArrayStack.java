package com.lurran.algorithms.dataStructrue;

import java.util.Iterator;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/16 8:53 下午
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a=(Item[]) new Object[1];
    private int N=0;


    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    private void resize(int max){
        Item[] temp=(Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i]=a[i];
        }
        a=temp;
    }

    public void push(Item item){
        if (N==a.length){
            resize(2*a.length);
        }
        a[N++]=item;
    }

    public Item pop(){
        Item item=a[--N];
        a[N]=null;
        if (N>0 && N==a.length/4){
            resize(a.length/2);
        }
        return item;

    }



    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i=N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

    }

    public static void main(String[] args) {
        ResizingArrayStack<String> resizingArrayStack=new ResizingArrayStack();
        System.out.println(resizingArrayStack.isEmpty());
        System.out.println( resizingArrayStack.size());
        resizingArrayStack.push("第一个元素");
        System.out.println(resizingArrayStack.isEmpty());
        resizingArrayStack.push("第二个元素");
        resizingArrayStack.push("第3个元素");
        resizingArrayStack.push("第4个元素");
        String pop = resizingArrayStack.pop();
        System.out.println(pop);
        Iterator<String> iterator = resizingArrayStack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
