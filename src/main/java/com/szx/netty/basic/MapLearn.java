package com.szx.netty.basic;

import java.util.HashMap;
import java.util.Map;

public class MapLearn {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("语文",1);
        map.put("数学",2);
        map.put("外语",3);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("key"+entry.getKey()+", value:"+entry.getValue());
        }
    }
}
