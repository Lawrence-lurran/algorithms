package com.lurran.algorithms.algorithms;



/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/20 8:40 下午
 */
public class Josepfu {







    static class CircleSingleLinkedList{
        private Boy first=new Boy(-1);

        public void add(int nums){
            if (nums<1){
                System.out.println("nums的值不正确");
                return;
            }
            Boy currentBoy=null;
            for (int i = 0; i < nums; i++) {
                Boy boy = new Boy(i);
                if (i==1){
                    first=boy;
                    first.setNext(first);
                    currentBoy=first;
                }else {
                    currentBoy.setNext(boy);
                    boy.setNext(first);
                    currentBoy=boy;
                }

            }

        }

        public void showBoys(){
            if (first==null){
                System.out.println("没有boy");
                return;
            }
            Boy current=first;
            while (true){
                System.out.println("小孩的编号"+current.no);
                if (current.next==first){
                    break;
                }
                current=current.getNext();
            }
        }

        public void countBoy(int startNo,int countNum,int nums){
           if (first==null || startNo<1 || startNo>nums ){
               System.out.println("参数输入有误，请重新输入");
               return;
           }
           Boy helper =first;
           while (true){
               if (helper.next==first){
                   break;
               }
               helper=helper.next;
           }
            for (int i = 0; i < startNo-1; i++) {
                first=first.next;
                helper=helper.next;
            }

            while (true){
                if (helper==first){
                    break;
                }
                for (int i = 0; i < countNum-1; i++) {
                    helper=helper.next;
                    first=first.next;
                }
                System.out.println("出圈的小孩为："+first);
                first=first.next;
                helper.next=first;
            }
            System.out.println("最后留在圈中的小孩编号为："+first.no);
        }
    }

    private static class Boy{
        private int no;
        private Boy next;

        @Override
        public String toString() {
            return "Boy{" +
                    "no=" + no +

                    '}';
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }

        public Boy(int no) {
            this.no = no;
        }
    }
}
