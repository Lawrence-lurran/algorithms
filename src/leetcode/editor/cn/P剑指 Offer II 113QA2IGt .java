//现在总共有 numCourses 门课需要选，记为 0 到 numCourses-1。 
//
// 给定一个数组 prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。 例如 
//prerequisites[i] = [ai, bi] 表示想要学习课程 ai ，需要先完成课程 bi 。 
//
// 请根据给出的总课程数 numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。 
//
// 可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 
//
// 示例 1: 
//
// 
//输入: numCourses = 2, prerequisites = [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 
//输入: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
// 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 示例 3: 
//
// 
//输入: numCourses = 1, prerequisites = [] 
//输出: [0]
//解释: 总共 1 门课，直接修第一门课就可。 
//
// 
//
// 提示: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// prerequisites 中不存在重复元素 
// 
//
// 
//
// 注意：本题与主站 210 题相同：https://leetcode-cn.com/problems/course-schedule-ii/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 9 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：课程顺序
@SuppressWarnings("all")
class P剑指OfferII113QA2IGt{
    public static void main(String[] args) {
        Solution solution = new P剑指OfferII113QA2IGt().new Solution();
        // TO TEST
        solution.findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];
        int[] res=new int[numCourses];
        Map<Integer, List<Integer>> graph = getGraph(prerequisites,inDegree);
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i]==0){
                queue.offer(i);
            }
        }
        int index=0;
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            res[index]=node;
            index++;
            if (graph.containsKey(node)){
                List<Integer> list = graph.get(node);
                for (int i = 0; i < list.size(); i++) {
                    inDegree[list.get(i)]--;
                    if (inDegree[list.get(i)]==0){
                        queue.offer(list.get(i));
                    }
                }
            }
            if (index==numCourses){
                return res;
            }

        }
        return new int[0];
    }
    public Map<Integer, List<Integer>> getGraph(int[][] prerequisites,int[] inDegree){
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            graph.putIfAbsent(start,new ArrayList<Integer>());
            graph.get(start).add(end);
            inDegree[end]++;
        }
        return graph;
    }
    public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visted,int start,List<Integer> res,List<Integer> temp,int numCourses){
        if (temp.size()==numCourses){
            res=new ArrayList<>(temp);
            return;
        }
        if (!graph.containsKey(start)){
            return;
        }
        List<Integer> list = graph.get(start);
        temp.add(start);
        visted.add(start);
        for (int i = 0; i < list.size(); i++) {
            if (visted.contains(list.get(i))){
                continue;
            }

            dfs(graph,visted,list.get(i),res,temp,numCourses);
            temp.remove(temp.size()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
