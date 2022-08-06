package com.lurran.algorithms.dataStructrue.binaryTree;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/30 3:11 下午
 */
@SuppressWarnings("all")
public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root=new HeroNode(1,"luran1");
        HeroNode node2=new HeroNode(2,"luran2");
        HeroNode node3=new HeroNode(3,"luran3");
        HeroNode node4=new HeroNode(4,"luran4");
        HeroNode node5=new HeroNode(5,"luran5");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        binaryTree.perOrder();
        System.out.println("================================================");
        binaryTree.infixOrder();
        System.out.println("================================================");
        binaryTree.postOrder();
        System.out.println("=====================查找结果=====================");
        HeroNode heroNode = binaryTree.perOrderSearch(5);
        if (heroNode == null) {
            System.out.println("没有找到该节点");
        }else {
            System.out.println(heroNode);
        }
        System.out.println("=====================查找结果=====================");
        HeroNode heroNode1 = binaryTree.infixOrderSearch(5);
        if (heroNode1 == null) {
            System.out.println("没有找到该节点");
        }else {
            System.out.println(heroNode1);
        }
        System.out.println("=====================查找结果=====================");
        HeroNode heroNode2 = binaryTree.postOrderSearch(5);
        if (heroNode2 == null) {
            System.out.println("没有找到该节点");
        }else {
            System.out.println(heroNode1);
        }

    }

    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void perOrder(){
        if (this.root!=null){
            this.root.perOrder();
        }else {
            System.out.println("当前二叉树为空，不能遍历");
        }
    }

    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("当前二叉树为空，不能遍历");
        }
    }

    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("当前二叉树为空，不能遍历");
        }
    }

    public HeroNode perOrderSearch(int no){
        if (this.root!=null){
            return this.root.perOrderSearch(no);
        }else {
            System.out.println("当前二叉树为空，不能查找");
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (this.root!=null){
            return this.root.infixOrderSearch(no);
        }else {
            System.out.println("当前二叉树为空，不能查找");
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if (this.root!=null){
            return this.root.postOrderSearch(no);
        }else {
            System.out.println("当前二叉树为空，不能查找");
            return null;
        }
    }

    public void delNode(int no){
        if (root != null) {
            if (root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("当前二叉树为空，不能查找");
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public void perOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.perOrder();
        }
        if (this.right!=null){
            this.right.perOrder();
        }
    }

    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode resNode=null;
        if (this.left!=null){
            resNode= this.left.infixOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        System.out.println("infixOrderSearch~次数");
        if (this.no==no){
            return this;
        }
        if (this.right!=null){
            resNode=  this.right.infixOrderSearch(no);
        }
        return resNode;
    }
    public HeroNode perOrderSearch(int no){
        System.out.println("perOrderSearch~次数");
        if (this.no==no){
            return this;
        }
        HeroNode resNode=null;
        if (this.left!=null){
            resNode= this.left.perOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=  this.right.perOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode resNode=null;
        if (this.left!=null){
            resNode= this.left.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=  this.right.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        System.out.println("post~次数");
        if (this.no==no){
            return this;
        }
        return resNode;
    }

    public void delNode(int no){
        if (this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }

        if (this.right!=null && this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }

}
