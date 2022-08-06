//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不
//会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-temperatures/ 
// Related Topics 栈 数组 单调栈 👍 23 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：每日温度
@SuppressWarnings("all")
class P剑指OfferII038IIQa4I{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII038IIQa4I().new Solution();
        // TO TEST
        solution.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack=new ArrayDeque<>();
        int len=temperatures.length;
        int[] res=new int[len];
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()){
                stack.push(i);
                continue;
            }
            int peek=stack.peek();
            if (temperatures[i]<=temperatures[peek]){
                stack.push(i);
            }
            while (temperatures[i]>temperatures[peek]){
                int pop=stack.pop();
                res[pop]=i-pop;
                if (stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                if (temperatures[i]<=temperatures[stack.peek()] ){
                    stack.push(i);
                    break;
                }
            }

        }
        while (!stack.isEmpty()){
            res[stack.pop()]=0;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
