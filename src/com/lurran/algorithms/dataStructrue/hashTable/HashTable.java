package com.lurran.algorithms.dataStructrue.hashTable;

import java.util.Scanner;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/29 5:24 下午
 */
public class HashTable {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key="";
        Scanner scanner = new Scanner(System.in); while(true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的 id");
                    id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    default:
                        break;
            }
        }

    }
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTable(int size) {
        this.size=size;
        empLinkedListArray=new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int empLinkedListNo=hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp empById = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (empById!=null){
            System.out.println("在第"+empLinkedListNo+"条连标中找到了该emp");
            System.out.println(empById);
        }else {
            System.out.println("没有找到该emp");
        }
    }

    public int hashFun(int id){
        return id % size;
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name, Emp next) {
        this.id = id;
        this.name = name;
        this.next = next;
    }
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String
    toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        Emp curEmp=head;
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }

    public void list(int no){
        if (head==null){
            System.out.println("第"+no+"条连标为空");
            return;
        }
        System.out.println("第"+no+"条链表信息为：");
        Emp curEmp=head;
        while (true){
            System.out.print("id="+curEmp.id);
            System.out.print("name="+curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if (head==null){
            System.out.println("连标为空");
            return null;
        }
        Emp curEmp=head;
        while (true){
            if (curEmp.id==id){
                break;
            }
            if (curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }
}
