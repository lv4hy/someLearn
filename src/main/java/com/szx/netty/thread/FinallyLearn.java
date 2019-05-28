package com.szx.netty.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class FinallyLearn {

    private Map<String, String> map = new HashMap<>();

    public Map<String, String> test(){
        try {
            System.out.println("before return");
            map.put("a", "try");
            return map;
        }finally {
            map.put("a", "finally");
            map = null;
            return new HashMap<>();
        }
    }

    private void test3(){
        map.put("a", "test3");
    }

    public static void main(String[] args) {
        FinallyLearn learn = new FinallyLearn();
        System.out.println(learn.test().get("a").toString());
    }
}
