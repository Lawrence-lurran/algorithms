//给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// 
//
// 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/ 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 16 👎 0

package leetcode.editor.cn;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：出现频率最高的 k 个数字
@SuppressWarnings("all")
class P剑指OfferII060G5c51o{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII060G5c51o().new Solution();
        // TO TEST
        solution.topKFrequent(new int[]{5,2,5,3,5,3,1,1,3},2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((e1,e2)->e1.getValue()-e2.getValue());
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size()<k){
                minHeap.add(entry);
            }else if(entry.getValue()>minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.add(entry);
            }
        }
        int[] res=new int[k];
        int i=0;
        for (Map.Entry<Integer, Integer> integerEntry : minHeap) {
            res[i]=integerEntry.getKey();
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
