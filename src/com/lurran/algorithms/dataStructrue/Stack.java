package com.lurran.algorithms.dataStructrue;

import java.util.Iterator;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/16 9:30 下午
 */
public class Stack<Item> implements Iterable<Item>{

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst=first;
        first =new Node();
        first.item=item;
        first.next=oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first=first.next;
        N--;
        return item;
    }

    public Item peak(){
        Item item = first.item;
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

    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        stack.push("第一个");
        stack.push("第二个");
        stack.push("第三个");
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
