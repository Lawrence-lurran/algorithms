package leetcode.editor.cn;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/1/30 11:26 上午
 */
public class Test {

    static class Solution {
        List<Integer> test=new ArrayList<>();
        public int countPairs(int[] nums, int k) {
            int res=0;
            int[][] indexs=new int[101][101];
            for(int i=0;i<nums.length;i++){
                int amount=indexs[nums[i]][0];
                if(amount!=0){
                    for(int j=1;j<amount+1;j++){
                        if((indexs[nums[i]][j]*i)%k==0){
                            res++;
                        }
                    }
                }
                indexs[nums[i]][0]++;
                indexs[nums[i]][indexs[nums[i]][0]]=i;

            }
            return res;
        }

        public long[] sumOfThree(long num) {

            if(num%3==0){
                long third=num/3;
                return new long[]{third-1,third,third+1};
            }
            return new long[0];

        }

        public List<Long> maximumEvenSplit(long finalSum) {
            if(finalSum%2==1){
                return new ArrayList<Long>();
            }
            List<Long> res=new ArrayList<>();

            long amount=finalSum;
            for (long i = 1; finalSum > 0; i++) {

                res.add((long)2*i);
                finalSum-=(2*i);

            }
            return res;
        }
        public int countEven(int num) {
            int res=0;

            for(int i=1;i<num;i++){
                int nums=i;
                int digit=nums%10;
                nums=nums/10;
                int ten=nums%10;
                nums=nums/10;
                int thod=nums%10;
                if((digit+ten+thod)%2==0){
                    res++;
                    test.add(i);
                }

            }
            return res;
        }
        public ListNode mergeNodes(ListNode head) {
            ListNode newHead=new ListNode();
            ListNode dummy=newHead;
            ListNode cur=head.next;
            int sum=0;
            while (cur!=null){
                while (cur.val!=0){
                    sum+=cur.val;
                    cur=cur.next;
                }
                dummy.next=new ListNode(sum);
                dummy=dummy.next;
                sum=0;
                cur=cur.next;
            }

            return newHead;
        }
        public String repeatLimitedString(String s, int repeatLimit) {
            StringBuffer sb=new StringBuffer();
            int[] latters=new int[26];
            //Map<Character,Integer> overLimit=new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                latters[s.charAt(i)-'a']++;
            }
            int overLimit=-1;
            for (int i = latters.length - 1; i >= 0; i--) {
                if (latters[i]==0){
                    continue;
                }
                for (int j = latters.length - 1; j >=i; j--) {
                    if (latters[j]==0){
                        continue;
                    }
                    int limit=repeatLimit;
                    int limitj=repeatLimit;
                    char latter= (char) ('a'+i);
                    char latterj= (char) ('a'+j);
                    while (latters[i]!=0 && limit>0 ){
                        sb.append(latter);
                        latters[i]--;
                        limit--;
                        while (i!=j && latters[j]>0 && limitj>0){
                            sb.append(latterj);
                            latters[j]--;
                            limitj--;
                        }
                    }
                }

            }
            char ch=sb.charAt(sb.length()-1);
            int re=0;
            for (int i = sb.length()-1; i >=0; i--) {
                if (sb.charAt(i)==ch) {
                    re++;
                }else {
                    break;
                }

            }
            int duoyu=re-repeatLimit;
            for (int i = 0; i < duoyu; i++) {
                sb.deleteCharAt(sb.length()-1-i);
            }

            return sb.toString();
        }
        public long coutPairs(int[] nums, int k) {
            if (nums[nums.length-1]<k){
                return 0;
            }
            Arrays.sort(nums);
            long res=0;
            for (int i = 0; i < nums.length-1; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if ((nums[i]*nums[j])%k==0){
                        res++;
                    }
                }
            }
            return res;
        }
        public long minimumTime(int[] time, int totalTrips) {
            double sum=1;
            long min=Integer.MAX_VALUE;
            for(int i=0;i<time.length;i++){
                sum*=time[i];
                min=Math.min(time[i],min);
            }
            double temp=0;
            for(int j=0;j<time.length;j++){
                temp+=sum/time[j];
            }
            double res=sum*totalTrips/temp;
            long res2=(long)Math.ceil(res);
            if (res2%min==0){
                return res2;
            }
            long l = res2 / min;

            return (l+1)*min;
        }
        public int mostFrequent(int[] nums, int key) {
            int len=nums.length;
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<len;i++){
                if(nums[i]==key && i+1<len){
                    map.put(nums[i+1],map.getOrDefault(nums[i+1],0)+1);
                }
            }
            int max=0;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                if(entry.getValue()>map.getOrDefault(max,0)){
                    max=entry.getKey();
                }
            }

            return max;
        }
        public int[] sortJumbled(int[] mapping, int[] nums) {
            int len= nums.length;
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<len;i++){
                int ma=toMap(nums[i],mapping);
                map.put(ma,nums[i]);
            }

            return nums;
//            int[] res=new int[nums.length];
//            res=Arrays.copyOf(nums,nums.length);
//            merge(nums,res,0,nums.length,mapping);
//            for (int i = 1; i < nums.length; i++) {
//                for (int j = i; j >0; j--) {
//                    int mapi=map(nums[j],mapping);
//                    int mapj=map(nums[j-1],mapping);
//                    if (mapi<mapj){
//                        swap(nums,j,j-1);
//                    }
//                }
//            }
            //return nums;

        }

        public void merge(int[] nums,int[] temp,int start,int end,int[] mapping){
            if(start+1>=end){
                return;
            }
            int mid=(start+end)/2;
            merge(temp,nums,start,mid,mapping);
            merge(temp,nums,mid,end,mapping);
            int i=start;
            int j=mid;
            int k=start;
            while(i<mid || j<end){
                int mapi=0;
                int mapj=0;
                if (i<mid){
                    mapi=map(nums[i],mapping);
                }
                if (j<end){
                    mapj=map(nums[j],mapping);
                }
                if(j==end || (i<mid && mapi<mapj)){
                    temp[k++]=nums[i++];

                }else{
                    temp[k++]=nums[j++];
                }
            }
        }
        public int map(int num,int[] mapping){
            StringBuffer res=new StringBuffer();
            while(num!=0){
                int temp=num/10;
                int digit=num%10;
                int tansfer=mapping[digit];
                res.append(tansfer);
                num=temp;
            }
            return Integer.parseInt(res.reverse().toString());
        }
        public void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        public int toMap(int num,int[] mapping){
            StringBuilder sb=new StringBuilder();
            if(num==0){
                return mapping[0];
            }
            while(num!=0){
                int digital=num%10;
                int mapNum=mapping[digital];
                num=num/10;
                sb.append(mapNum);
            }
            return Integer.parseInt(sb.reverse().toString());
        }
        public List<String> cellsInRange(String s) {
            String[] str=s.split(":");
            String start=str[0];
            String end=str[str.length-1];
            char startChar=start.charAt(0);
            char endChar=end.charAt(0);
            int length=endChar-startChar+1;
            char endNum=end.charAt(1);
            char startNum=start.charAt(1);
            int ednum=Integer.parseInt(endNum+"");
            int stnum=Integer.parseInt(startNum+"");

            List<String> res=new ArrayList<>();
            for(int i=0;i<length;i++){
                for(int j=stnum;j<ednum+1;j++){
                    StringBuilder sb=new StringBuilder();
                    char nowChar=(char)(startChar+i);
                    int nowNum=j;
                    res.add(sb.append(nowChar).append(nowNum).toString());
                }
            }
            return res;
        }
        public long minimalKSum(int[] nums, int k) {
            Set<Integer> set=new TreeSet<>();
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                set.add(nums[i]);
            }

            long res=0L;
            List<Integer> temp=new ArrayList<>();
            int sum=0;
            for (Integer integer : set) {
                if (integer<k){
                    k+=1;
                    sum+=integer;
                    temp.add(integer);
                }else{
                    break;
                }
            }

            res=((long) (1L + k) *k)/2;
            res-=sum;
            return res;
        }
        public int countHighestScoreNodes(int[] parents) {
            Map<Integer,Integer> map=new HashMap<>();
            Map<Integer,List<Integer>> childrens=new HashMap<>();
            for(int i=1;i<parents.length;i++){
                map.put(parents[i],map.getOrDefault(parents[i],1)+1);
                childrens.putIfAbsent(parents[i],new ArrayList<>());
                childrens.get(parents[i]).add(i);
            }
            for (Integer integer : map.keySet()) {
                for (int i = 0; i < childrens.get(integer).size(); i++) {
                    map.put(integer,map.get(integer)+map.getOrDefault(childrens.get(integer).get(i),1)-1);
                }
            }
            Map<Integer,Integer> res=new HashMap<>();
            for(int j=0;j<parents.length;j++){
                if(j==0){
                    int temp=1;
                    List<Integer> list = childrens.get(j);
                    int size= list.size();
                    for(int k=0;k<size;k++){
                        temp=temp*map.getOrDefault(list.get(k),1);
                    }
                    res.put(temp,1);
                }else{
                    int temp=1;
                    if (childrens.containsKey(j)){
                        List<Integer> list = childrens.get(j);
                        int size=list.size();
                        for(int k=0;k<size;k++){
                            temp=temp*map.getOrDefault(list.get(k),1);
                        }
                    }
                    int pa=map.get(0);
                    pa-=map.getOrDefault(j,1);
                    temp*=pa;
                    res.put(temp,res.getOrDefault(temp,0)+1);
                }
            }
            int max=0;
            for (Integer integer : res.keySet()) {
                max=Math.max(integer,max);
            }
            return max==0?0:res.get(max);
        }
        public long maximumSubsequenceCount(String text, String pattern) {
            StringBuilder sb=new StringBuilder(text);
            sb.insert(0,pattern.charAt(0));
            Map<Character,List<Integer>> map=new HashMap<>();
            map.put(pattern.charAt(0),new ArrayList<>());
            map.put(pattern.charAt(1),new ArrayList<>());
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)==pattern.charAt(0) || sb.charAt(i)==pattern.charAt(1)){
                    map.get(sb.charAt(i)).add(i);
                }
            }
            int res=0;
            List<Integer> list1=map.get(pattern.charAt(0));
            List<Integer> list2=map.get(pattern.charAt(1));
            for(int i=0;i<list1.size();i++){
                for(int j=0;j<list2.size();j++){
                    if(list1.get(i)<list2.get(j)){
                        res++;
                    }
                }
            }
            return res;
        }
        public int halveArray(int[] nums) {

            double sum=0;
            Arrays.sort(nums);

            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
            }
            double half=sum/2;
            double halfMax=0;
            double max=0;
            double sumHalf=0;
            int res=0;
            Queue<Double> queue=new ArrayDeque<>();
            double maxHalf=0;
            for(int i=nums.length-1;i>=0;){
                if (queue.isEmpty()){
                    max=nums[i];
                    i--;
                }else {
                    max=Math.max(nums[i],queue.peek());
                    if (max==queue.peek()){
                        queue.poll();
                    }else {
                        i--;
                    }
                }
                halfMax=max/2;
                queue.add(halfMax);

                sumHalf+=halfMax;
                res++;
                if(sumHalf>=half){
                    return res;
                }
            }
            return res;
        }
        public int countHillValley(int[] nums) {
            Set<Integer> res=new HashSet<>();
            int num=0;
            for(int i=1;i<nums.length-1;i++){
                int j=i-1;
                boolean flag=true;
                while( j>=0 && nums[j]==nums[i]){
                    j--;
                }
                if(j<0){
                    continue;
                }else if(nums[j]>nums[i]){
                    flag=!flag;
                }
                int k=i+1;
                while(k<nums.length && nums[k]==nums[i]){
                    k++;
                }
                if(k==nums.length){
                    continue;
                }else if(nums[k]>nums[i]){
                    flag=!flag;
                }
                if(flag){
                    res.add(nums[i]);
                    num++;
                }
                if(k-1<nums.length && nums[k-1]==nums[i]){
                    i=k-1;
                }

            }
            return num;
        }
        public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
            double[][] bob=new double[12][2];
            for(int i=0;i<12;i++){
                bob[i][0]=aliceArrows[i]+1;
                bob[i][1]=i/bob[i][0];
            }


            return new int[1];
        }

    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        Map<Student,Integer> map=new HashMap<>();

        for (Map.Entry<Student, Integer> studentIntegerEntry : map.entrySet()) {
            System.out.println(studentIntegerEntry.getKey());
        }

    }
}
