package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinStack {

    LinkedList<Integer> ll;
    PriorityQueue<Integer> ml;
    Integer min = null;
    /** initialize your data structure here. */
    public MinStack() {
        ll =new LinkedList<>();
        ml = new PriorityQueue<>();
    }

    public void push(int x) {
        if (min == null || min > x) {
            min = x;
        }
        ml.add(x);
        ll.add(x);
    }

    public void pop() {
        ml.remove(ll.pollLast());
    }

    public int top() {
        return ll.getLast();
    }

    public int getMin() {
        return ml.peek();
    }
}
