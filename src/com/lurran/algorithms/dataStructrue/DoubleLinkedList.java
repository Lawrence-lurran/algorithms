package com.lurran.algorithms.dataStructrue;

import java.util.Stack;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/18 8:56 下午
 */
public class DoubleLinkedList {
    private Node head=new Node(0,"","");

    public void add(Node node){
        Node temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }

    public void list(){
        if (head.next==null){
            return;
        }
        Node temp=head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public void addByOrder(Node node){
       Node temp=head;
       boolean flag=false;
       while (true){
           if (head.next==null){
               break;
           }
           if (temp.next.no>node.no){
               break;
           }else if (temp.next.no==node.no){
               flag=true;
               break;
           }
           temp=temp.next;
       }
       if (flag){
           System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", node.no);
       }else {
           node.next=temp.next;
           temp.pre=node;
       }
    }

    public void update(Node node){
        if (head.next==null){
            return;
        }
        Node temp=head;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.no== node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=node.name;
            temp.nickname=node.nickname;
        }else {
            addByOrder(node);
        }
    }

    public Node delete(int no){

        if (head.next==null){
            return null;
        }
        Node temp=head.next;

        boolean flag=false;
        while (true){
            if (temp==null){
                break;
            }else if (temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }
            return temp;
        }else {
            System.out.println("没有该节点");
            return null;
        }
    }

    public int getSize(){
        if (head.next==null){
            return 0;
        }
        Node temp=head;
        int size=0;
        Node current=head.next;
        while (current!=null){
           size++;
           current=current.next;
        }

        return size;
    }

    public Node getNodeByLastIndex(int index){
        if (head.next==null){
            return null;
        }
        int size=getSize();
        if (index<=0 || index>size){
            return null;
        }
        Node current=head.next;
        for(int i =0; i< size - index; i++) {
            current = current.next; }
        return current;
    }

    public void reverseList(Node head){
        if (head.next==null || head.next.next==null){
            return;
        }
        Node reverseNode=new Node(0,"","");
        Node current =head.next;
        Node next;
        while (current!=null){
             next=current.next;
             current.next=reverseNode.next;
             reverseNode.next=current;
             current=next;

        }
        head.next=reverseNode.next;
    }

    public void listReverse(Node head){
        if (head.next==null){
            return;
        }
        Stack stack=new Stack();
        Node current= head.next;
        while (current!=null){
            stack.push(current);
            current=current.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }





    }






    private static class Node{
        private  int no;
        private String name;
        private String nickname;
        private Node next;
        private Node pre;

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }

        public Node(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;

        }
    }

    public static void main(String[] args) {
        DoubleLinkedList singleLinkedList = new DoubleLinkedList();
        singleLinkedList.add(new Node(1,"lurarn","luran"));
        singleLinkedList.add(new Node(2,"lurarn","luran"));
        singleLinkedList.add(new Node(3,"lurarn","luran"));
        singleLinkedList.list();
        singleLinkedList.reverseList(singleLinkedList.head);
        System.out.println("反转之后");
        singleLinkedList.list();
        System.out.println("反转之后");

        singleLinkedList.listReverse(singleLinkedList.head);

    }
}
