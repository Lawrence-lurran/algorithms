//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 24 👎 0

package leetcode.editor.cn;
//Java：回文链表
@SuppressWarnings("all")
class P剑指OfferII027AMhZSa{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII027AMhZSa().new Solution();
        // TO TEST
        ListNode head=ListNode.creatList(new int[]{1,2,2,1});
        solution.isPalindrome(head);

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=slow.next;
        slow.next=null;
        ListNode tailHead=reverse(newHead);
        while (tailHead!=null && head!=null){
            if (tailHead.val!=head.val){
                return false;
            }
            tailHead=tailHead.next;
            head=head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
