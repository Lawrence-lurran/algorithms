package leetcode.editor.cn;

import java.util.*;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/3/29 7:15 下午
 */
public class Temp {
    public static void main(String[] args) {
        String [] orders = {
                "订单号，商品ID，城市ID",
                "1000，8000，2001",
                "1000，8201，2001",
                "1000，8203，2001",
                "1032，8201，2301",
                "1031，8201，2201"
                //... 数量级：数千万条
        };

        String [] cities = {
                "城市ID，城市名称",
                "2001，北京",
                "2301，上海",
                "2201，深圳"
                //... 数量级：数千条
        };
        String [] results = groupOrdersByCities(orders, cities);
        for (String r: results) {
            System.out.println(r);
        }
    }
    public static String [] groupOrdersByCities (String [] orders, String [] cities){
        // 这是返回结果示例
        int cityLen=cities.length-1;
        String[] re=new String[cityLen];
        Map<String,Integer> res=new HashMap<>();
        Map<String,String> map=new HashMap<>();
        Map<String, Set<String>> order=new HashMap<>();
        for(int i=1;i<cities.length;i++){
            String[] temp=cities[i].split("，");
            map.put(temp[0],temp[1]);
        }
        for(int i=1;i<orders.length;i++){
            String[] temp=orders[i].split("，");
            String cityId=temp[2];
            String orderId = temp[0];
            String cityName = map.get(cityId);
            order.putIfAbsent(cityName,new HashSet<>());
            if (order.get(cityName).contains(orderId)){
                continue;
            }
            order.get(cityName).add(orderId);
            res.put(cityName,res.getOrDefault(cityName,0)+1);
        }
        int i=0;
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
             re[i]=entry.getKey()+":"+entry.getValue();
             i++;
        }
        return re;
    }
}
