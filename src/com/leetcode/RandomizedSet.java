package com.leetcode;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> set = null;
    List<Integer> list = null;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashMap();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer i = set.get(val);
        if (i == null) {
            list.add(Integer.valueOf(val));
            set.put(val, list.size()-1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer i = set.get(val);
        if (i== null) {
            return false;
        }
        set.remove(val);
        list.remove(i.intValue());
        if (list.size() > i ) {
            int y = list.remove(list.size()-1);
            set.put(y, i);
            list.add(i,y);
        }

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return  list.get((int) ((Math.random() * (list.size() - 0)) + 0));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(3);
        rs.insert(-2);
        rs.remove(2);
        rs.insert(1);
        rs.insert(-3);
        rs.insert(-2);
        rs.remove(-2);
        rs.remove(3);
        rs.insert(-1);
        rs.remove(-3);
        rs.insert(1);
        rs.insert(-2);
        rs.insert(-2);
        rs.insert(-2);
        System.out.println(rs.getRandom());
    }
}
