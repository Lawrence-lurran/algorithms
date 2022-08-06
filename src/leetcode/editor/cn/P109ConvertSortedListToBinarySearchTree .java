//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 646 👎 0

package leetcode.editor.cn;
//Java：有序链表转换二叉搜索树
class P109ConvertSortedListToBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new P109ConvertSortedListToBinarySearchTree().new Solution();
        // TO TEST
        ListNode root1=new ListNode(-10);
        ListNode root2=new ListNode(-3);
        ListNode root3=new ListNode(0);
        ListNode root4=new ListNode(5);
        ListNode root5=new ListNode(9);
        root1.next=root2;
        root2.next=root3;
        root3.next=root4;
        root4.next=root5;
        solution.sortedListToBST(root1);
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedToBST(head,null);
    }
    public TreeNode sortedToBST(ListNode head,ListNode tail){
        if (tail==head ){
            return null;
        }

        ListNode fast=head;
        ListNode slow=head;

        while (fast!=tail && fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=sortedToBST(head,slow);
        root.right=sortedToBST(slow.next,tail);


        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
