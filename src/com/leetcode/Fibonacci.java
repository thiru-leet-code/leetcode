package com.leetcode;

public class Fibonacci {

    int finbonacci(int i) {
        if (i<=2) {
            return 1;
        }
        return finbonacci(i-1) + finbonacci(i-2);
    }

    int factorial(int i) {
        if (i<=1) {
            return 1;
        }
        return i*factorial(i-1);
    }

    public static void main (String[] s) {
        Fibonacci f = new Fibonacci();
        for (int i = 1; i <=10; i++) {
            System.out.println(i + " : " + f.finbonacci(i));
        }
        System.out.println("Factorial of 5: " + f.factorial(5));
    }
}
