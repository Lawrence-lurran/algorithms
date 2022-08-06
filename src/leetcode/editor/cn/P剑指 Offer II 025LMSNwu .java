//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 👍 22 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//Java：链表中的两数相加
@SuppressWarnings("all")
class P剑指OfferII025LMSNwu{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII025LMSNwu().new Solution();
        // TO TEST
        ListNode l1=ListNode.creatList(new int[]{7,2,4,3});
        ListNode l2=ListNode.creatList(new int[]{5,6,4});
        solution.addTwoNumbers(l1,l2);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1=new ArrayDeque<>();
        Deque<ListNode> stack2=new ArrayDeque<>();
        push(stack1,l1);
        push(stack2,l2);
        int carry=0;
        ListNode pre=null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int x= stack1.isEmpty() ? 0:stack1.removeFirst().val;
            int y= stack2.isEmpty() ? 0:stack2.removeFirst().val;
            int sum= x+y+carry;
            carry=sum/10;
            sum%=10;
            ListNode node=new ListNode(sum);
            node.next=pre;
            pre=node;
        }
        if (carry>0){
            ListNode node=new ListNode(carry);
            node.next=pre;
            pre=node;
        }
        return pre;
    }
    public void push(Deque stack,ListNode head){
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
