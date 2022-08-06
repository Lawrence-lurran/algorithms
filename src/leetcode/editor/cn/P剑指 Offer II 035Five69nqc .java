//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 6 👎 0

package leetcode.editor.cn;

import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//Java：最小时间差
@SuppressWarnings("all")
class P剑指OfferII035Five69nqc{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII035Five69nqc().new Solution();
        // TO TEST
        List<String> list=new ArrayList<>();
        list.add("05:31");
        list.add("22:08");
        list.add("00:35");
        solution.findMinDifference(list);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference (List<String> timePoints) {
        boolean[] data=new boolean[1440];
        for (int i = 0; i < timePoints.size(); i++) {
            int minutes=prase(timePoints.get(i));
            if (data[minutes]){
                return 0;
            }
            data[minutes]=true;
        }
        int min=2000;
        int old=-1;
        int first=-1;
        for (int i = 0; i < 1440; i++) {
            if (data[i]){
                if (old==-1){
                    old=i;
                    first=i;
                }else {
                    min=Math.min(i-old,min);
                    old=i;
                }

            }
        }
        min=Math.min(first+1440-old,min);
        return min;
    }
    public int prase(String date){
        String[] times=date.split(":");
        int hours=Integer.parseInt(times[0]);
        int minutes=Integer.parseInt(times[1]);
        return hours*60+minutes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
