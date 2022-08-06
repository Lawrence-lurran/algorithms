package com.lurran.algorithms.dataStructrue.binaryTree.threadedBinaryTree;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/10/1 10:10 下午
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();


        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println(leftNode);
        System.out.println(rightNode);
        threadedBinaryTree.threadedList();
    }

    private HeroNode root;
    private HeroNode pre=null;

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
    public void threadedList(){
        HeroNode curNode=root;
        while (curNode!=null){
            while (curNode.getLeftType()==0){
                curNode=curNode.getLeft();
            }
            System.out.println(curNode);
            while (curNode.getRightType()==1){
                curNode=curNode.getRight();
                System.out.println(curNode);
            }
            curNode=curNode.getRight();
        }
    }


    public void threadedNodes(){
        threadedNodes(root);
    }

    public void threadedNodes(HeroNode node){
        if (node==null){
            return;
        }
        threadedNodes(node.getLeft());
        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        threadedNodes(node.getRight());
    }
}
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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
