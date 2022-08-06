//
// 运用所掌握的数据结构，设计和实现一个 LRU (Least Recently Used，最近最少使用) 缓存机制 。 
//
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// 
//
// 
//
// 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 注意：本题与主站 146 题相同：https://leetcode-cn.com/problems/lru-cache/ 
// Related Topics 设计 哈希表 链表 双向链表 👍 18 👎 0

package leetcode.editor.cn;


import java.util.*;

//Java：最近最少使用缓存
@SuppressWarnings("all")
class P剑指OfferII031OrIXps{
    public static void main(String[] args) {
        //Solution solution = new P剑指 Offer II 031OrIXps().new Solution();
        // TO TEST
        LRUCache l=new P剑指OfferII031OrIXps().new LRUCache(2);
        l.put(2,1);
        l.get(2);
//        l.put(2,2);
//        l.put(3,3);
//        l.get(2);
//        l.put(4,4);
//        l.get(1);
//        l.get(3);
//        l.get(4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
        ListNode2 head;
        ListNode2 tail;
        Map<Integer,ListNode2> map;
        int capacity;
        int size;

    public LRUCache(int capacity) {
        this.size=0;
        this.map=new HashMap<>(capacity);
        this.capacity=capacity;
        this.head=new ListNode2();
        this.tail=new ListNode2();
        head.next=tail;
        tail.prev=head;

    }
    
    public int get(int key) {
        ListNode2 node=map.get(key);
        if (node==null){
            return -1;
        }
        moveTohead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode2 node2=map.get(key);
        if (node2!=null){
            node2.val=value;
            moveTohead(node2);

        }else {
            ListNode2 newNode=new ListNode2(key,value);
            map.put(key,newNode);
            addToHead(newNode);
            size++;
            if (size>capacity){
                ListNode2 remove=removeTail();
                map.remove(remove.key);
                size--;
            }
        }
    }

    public void moveTohead(ListNode2 node2){
        removeNode(node2);
        addToHead(node2);
    }
    public void removeNode(ListNode2 node2){
        node2.prev.next=node2.next;
        node2.next.prev=node2.prev;
    }
    public void addToHead(ListNode2 node2){
        node2.next=head.next;
        head.next.prev=node2;
        head.next=node2;
        node2.prev=head;

    }
    public ListNode2 removeTail(){
        ListNode2 res=tail.prev;
        removeNode(res);
        return res;
    }
}
    public class ListNode2 {
        int val;
        int key;
        ListNode2 next;
        ListNode2 prev;
        ListNode2() {

        }
        ListNode2(int key,int val) {
            this.val = val;
            this.key=key;
        }
        ListNode2(int val, ListNode2 next,ListNode2 prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
