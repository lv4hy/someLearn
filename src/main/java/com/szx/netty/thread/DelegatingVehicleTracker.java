package com.szx.netty.thread;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class DelegatingVehicleTracker {
    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiedMap;

    public DelegatingVehicleTracker(Map<String, Point> pointMap) {
        this.locations = new ConcurrentHashMap<>(pointMap);
        this.unmodifiedMap = Collections.unmodifiableMap(locations);
    }
    public Map<String, Point> getLocations(){
        return unmodifiedMap;
    }

    public Map<String, Point> getLocationShallowCopy(){
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    public Point getLocation(String key){
        return unmodifiedMap.get(key);
    }

    public void setLocation(String id, int x, int y){
        if(locations.replace(id, new Point(x,y)) == null){
            throw new IllegalArgumentException("sss");
        }
    }

    public static void main(String[] args) {
        Map<String, Point> map = new HashMap<>();
        map.put("a", new Point(1,2));
        map.put("b", new Point(3,4));
        DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(map);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                tracker.setLocation("a", 5,6);
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(tracker.getLocation("a"));
            }
        });

        threadA.start();
        threadB.start();
    }
}
