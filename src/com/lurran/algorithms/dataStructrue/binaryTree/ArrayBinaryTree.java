package com.lurran.algorithms.dataStructrue.binaryTree;


/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/10/1 5:55 下午
 */
public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.perOrder();
        arrayBinaryTree.infixOrder();
        arrayBinaryTree.postOrder();
    }
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void perOrder(){
        this.perOrder(0);
    }

    public void infixOrder(){
        this.infixOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }

    public void perOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        if ((index*2+1)<arr.length){
            perOrder(index*2+1);
        }

        if ((index*2+2)<arr.length){
            perOrder(index*2+2);
        }
    }
    public void infixOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空");
        }
        if ((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }
        System.out.println(arr[index]);

        if ((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
    }

    public void postOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空");
        }
        if ((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }
        if ((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }


}


