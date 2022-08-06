//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反
//序列化为原始的树结构。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，也可以采用其他的方法解决这
//个问题。 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 20 👎 0

package leetcode.editor.cn;

import java.sql.ClientInfoStatus;
import java.util.*;

//Java：序列化与反序列化二叉树
@SuppressWarnings("all")
class P剑指OfferII048H54YBf{
    public static void main(String[] args) {
        Codec codec = new P剑指OfferII048H54YBf().new Codec();
        // TO TEST
        TreeNode root1=new TreeNode(1);
        TreeNode root2=new TreeNode(2);
        TreeNode root3=new TreeNode(3);
        TreeNode root4=new TreeNode(4);
        TreeNode root5=new TreeNode(5);
        TreeNode root6=new TreeNode(6);
        TreeNode root7=new TreeNode(7);
        root1.left=root2;
        root1.right=root3;
        root3.left=root4;
        root3.right=root5;
        root4.left=root6;
        root4.right=root7;
        String serial=codec.serialize(root1);
        System.out.println(serial);
        codec.deserialize(serial);


    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> deque=new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        if (root==null){
            return Arrays.toString(res.toArray());
        }
        deque.addFirst(root);
        TreeNode temp=new TreeNode(0);
        while (!deque.isEmpty()){
            TreeNode node=deque.removeLast();
            if (node==temp){
                res.add(null);
                continue;
            }
            res.add(node.val);
            if (node.left!=null){
                deque.addFirst(node.left);
            }else {
                deque.addFirst(temp);
            }
            if (node.right!=null){
                deque.addFirst(node.right);
            }else {
                deque.addFirst(temp);
            }

        }
        for (int i = res.size()-1; i > 0; i--) {
            if (res.get(i)==null){
                res.remove(i);
            }else {
                break;
            }

        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        String[] strings=data.replace(" ","").replaceAll("\\[","").replace("]","").split(",");
        if (strings[0].equals("") && strings.length==1){
            return null;
        }
        Deque<TreeNode> queue=new ArrayDeque<>();
        TreeNode root=new TreeNode(Integer.parseInt(strings[0]));
        queue.add(root);
        TreeNode isNull=new TreeNode(-1);
        for (int i = 0; i < strings.length; i++) {
            TreeNode temp=queue.poll();
            if (temp==isNull){
                continue;
            }
            if (2*i+1 <strings.length){
                if(strings[2*i+1].equals("null")){
                    temp.left=null;
                    queue.add(isNull);
                }else {
                    TreeNode node=new TreeNode(Integer.parseInt(strings[2*i+1]));
                    temp.left=node;
                    queue.add(node);

                }
            }
            if (2*i+2 <strings.length){
                if(strings[2*i+2].equals("null")){
                    temp.left=null;
                    queue.add(isNull);
                }else {
                    TreeNode node=new TreeNode(Integer.parseInt(strings[2*i+2]));
                    temp.right=node;
                    queue.add(node);
                }
            }
        }
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] nodes=data.replace(" ","").replaceAll("\\[","").replace("]","").split(",");
        if (nodes[0].equals("") && nodes.length==1){
            return null;
        }
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList();
        TreeNode parent = root;
        boolean isLeft = true;
        for(int i = 1; i < nodes.length; i++){
            TreeNode cur = getNode(nodes[i]);
            if(isLeft){
                parent.left = cur;
            }else{
                parent.right = cur;
            }
            if(cur != null){
                parents.add(cur);
            }
            isLeft = !isLeft;
            if(isLeft){
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val){
        if(val.equals("null")){
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
