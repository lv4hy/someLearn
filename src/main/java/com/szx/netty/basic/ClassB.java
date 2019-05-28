package com.szx.netty.basic;

public class ClassB extends ClassA{

    public ClassB() {
        System.out.println("classB construct");
    }

    public static void main(String[] args) {
        ClassB classB = new ClassB();
    }
}
