//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
// Related Topics 字符串 回溯 👍 16 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：复原 IP
@SuppressWarnings("all")
class P剑指OfferII087ZeroOn3uN{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII087ZeroOn3uN().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        backTrack(s,0,0,"","",res);
        return res;
    }
    public void backTrack(String s,int i,int segI,String seg,String ip,List<String> res){
        if (i==s.length() && segI==3 && isValid(seg)){
            res.add(ip+seg);
        }else if (i<s.length() && segI<=3){
            char ch=s.charAt(i);
            if (isValid(seg+ch)){
                backTrack(s,i+1,segI,seg+ch,ip,res);
            }
            if (seg.length()>0 && segI<3){
                backTrack(s,i+1,segI+1,""+ch,ip+seg+".",res);
            }
        }
    }
    public boolean isValid(String seg){
        int num=Integer.parseInt(seg);
        return num<=255 && (seg.equals("0")||seg.charAt(0)!='0');
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
