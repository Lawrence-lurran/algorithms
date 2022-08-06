package interviews.ali;

import leetcode.editor.cn.ListNode;
import leetcode.editor.cn.TreeNode;
import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/15 11:08 上午
 */
public class SingletonInner {
    private SingletonInner singletonInner=null;
    private static class Inner{
        private static final SingletonInner singletonInner=new SingletonInner();
    }
    public static final SingletonInner getSingletonInner(){
        return Inner.singletonInner;
    }

    private static volatile int num=1;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                2,
                2,
                100,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.DiscardPolicy());

        BlockingQueue<Integer> blockingQueue1=new LinkedBlockingQueue<>(1);
        blockingQueue1.put(1);
        BlockingQueue<Integer> blockingQueue2=new LinkedBlockingQueue<>(1);
        ReentrantLock reentrantLock=new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Semaphore semaphore1=new Semaphore(1);
        Semaphore semaphore2=new Semaphore(0);
        Object o=new Object();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
        String str=null;
        Character character='a';

        executor.execute(new Runnable() {
            @Override
            public void run() {
                while (num<100){
                    try {
                        semaphore1.acquire();
                        System.out.println("线程1："+num);
                        num++;
                        semaphore2.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        executor.execute(()->{
                while (num<=100){
                    try {
                        semaphore2.acquire();
                        System.out.println("线程2："+num);
                        num++;
                        semaphore1.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        });
        executor.shutdown();
    }
    public void inOrder(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> re=new ArrayList<>();
        TreeNode cur=node;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            re.add(cur);
            cur=cur.right;
        }
    }
    public void preOrder(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> re=new ArrayList<>();
        TreeNode cur=node;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                re.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            cur=cur.right;
        }
    }





}
