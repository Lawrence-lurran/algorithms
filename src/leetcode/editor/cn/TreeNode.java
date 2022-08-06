package leetcode.editor.cn;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/1/17 7:55 下午
 */
public class TreeNode {

    public int val;
     public TreeNode left;
    public TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;this.left = left;
          this.right = right;

      }
}
