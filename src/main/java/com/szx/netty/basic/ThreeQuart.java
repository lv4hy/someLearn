package com.szx.netty.basic;

public class ThreeQuart {

    public static double qube(int input){
        double x = 1.0;
        do{
            x = x - getY(x, input)/getDouble(x);
        }while ((getY(x, input)) > 0.001 || (getY(x, input)) < -0.001);
        return x;
    }

    private static double getDouble(double x){
        return 3 * x * x;
    }

    private static double getY(double x, double input){
        return x * x * x - input;
    }

    public static void main(String[] args) {
        System.out.println(qube(64));
    }
}
