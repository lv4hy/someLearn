package com.szx.netty.thread;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentLinkedQueue<E> {
    private final Node<E> dummy = new Node<>(null, null);
    private final AtomicReference<Node<E>> tail = new AtomicReference<>(dummy);
    private final AtomicReference<Node<E>> head = new AtomicReference<>(dummy);

    private static class Node<E>{
        private final E item;
        private final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> node) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(node);
        }
    }

    public void put(E item){
        Node<E> newNode = new Node<>(item, null);
        Node<E> curTail = tail.get();
        Node<E> curTailNext = curTail.next.get();
        while (true){
            if(tail.get() == curTail){
              if(curTailNext == null){
                  if(curTail.next.compareAndSet(null, newNode)){
                      tail.compareAndSet(curTail, newNode);
                      return;
                  }
              }else {
                  tail.compareAndSet(curTail, curTailNext);
              }
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("A");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("B");
            }
        });

        threadA.start();
        threadB.start();

        while (queue.head.get().next != null){
            System.out.print(queue.head.get().item);
            System.out.print(" -> ");
        }
    }
}
