//给你一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例： 
//
// 
// 线程 A 将会调用 foo() 方法，而 
// 线程 B 将会调用 bar() 方法 
// 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出："foobar"
//解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出："foobarfoobar"
//解释："foobar" 将被输出两次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 多线程 👍 148 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//Java：交替打印 FooBar
@SuppressWarnings("all")
class P1115PrintFoobarAlternately{
    public static void main(String[] args) {
        FooBar solution = new P1115PrintFoobarAlternately().new FooBar(2);
        // TO TEST



    }
    //leetcode submit region begin(Prohibit modification and deletion)
class FooBar {
    private int n;
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    private Semaphore sfoo=new Semaphore(1);
    private Semaphore bfoo=new Semaphore(0);
    private BlockingQueue<Integer> blockingQueue1=new ArrayBlockingQueue<>(1);
    private BlockingQueue<Integer> blockingQueue2=new ArrayBlockingQueue<>(1);
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private boolean flag=true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!flag){
                    condition.await();
                }
                printFoo.run();
                flag=false;
                condition.signalAll();
            }finally {
                lock.unlock();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag){
                    condition.await();
                }
                printBar.run();
                flag=true;
                condition.signalAll();
            }finally {
                lock.unlock();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
