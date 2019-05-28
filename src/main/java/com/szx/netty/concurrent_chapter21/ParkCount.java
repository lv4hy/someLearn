package com.szx.netty.concurrent_chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkCount {
    private AtomicInteger totalCount = new AtomicInteger();
    private List<Integer> everyDayCount = new ArrayList<>();
    private List<Door> doors = new ArrayList<>();

    public ParkCount(int size) {
        this.doors = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            doors.add(new Door("door-"+i));
        }
    }

    class Door extends Thread{
        private AtomicInteger doorCounter = new AtomicInteger(0);

        public Door(String name) {
            super(name);
        }

        public void enter(){
            synchronized (this){
                doorCounter.incrementAndGet();
                totalCount.incrementAndGet();
            }
        }

        @Override
        public void run() {
            while (true){
                this.enter();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public AtomicInteger getDoorCounter() {
            return doorCounter;
        }

        public void setDoorCounter(AtomicInteger doorCounter) {
            this.doorCounter = doorCounter;
        }
    }

    public AtomicInteger getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(AtomicInteger totalCount) {
        this.totalCount = totalCount;
    }

    public List<Integer> getEveryDayCount() {
        return everyDayCount;
    }

    public void setEveryDayCount(List<Integer> everyDayCount) {
        this.everyDayCount = everyDayCount;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }
}
