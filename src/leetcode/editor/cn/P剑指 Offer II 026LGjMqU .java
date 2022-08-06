//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 👍 28 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：重排链表
@SuppressWarnings("all")
class P剑指OfferII026LGjMqU{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII026LGjMqU().new Solution();
        // TO TEST
        ListNode head=ListNode.creatList(new int[]{1,2,3,4});
        solution.reorderList(head);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack=new LinkedList<>();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        int length=stack.size();
        while (!stack.isEmpty()){
            if (stack.size()==length/2 || stack.peek()==head){
                head.next=null;
                break;
            }
            ListNode tail=stack.pop();
            ListNode next=head.next;
            head.next=tail;
            tail.next=next;
            head=next;
        }
    }
    public void reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
