package com.lurran.algorithms.dataStructrue;

import javax.jnlp.ClipboardService;
import java.util.Iterator;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/16 10:41 下午
 */
public class Queue <Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N=0;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast=last;
        last.item=item;
        last.next=null;
        if (isEmpty()){
            first=last;
        }else {
            oldLast.next=last;
        }
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first=first.next;
        if (isEmpty()){
            last=null;
        }
        N--;
        return item;
    }




    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current=first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }
}
