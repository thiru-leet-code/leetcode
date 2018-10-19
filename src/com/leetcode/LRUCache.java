package com.leetcode;
import java.util.*;

class LRUCache {
    
    Map<Integer, Integer> cache = new HashMap<>();
    LinkedList<Integer> queue = new LinkedList<>();
    int sizeLimit = 0;

    public LRUCache(int capacity) {
        this.sizeLimit = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            queue.remove(Integer.valueOf(key));
            queue.add(Integer.valueOf(key));
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.size() == (sizeLimit) && !cache.containsKey(key)) {
            int removeKey = queue.poll();
            cache.remove(removeKey);
            System.out.println("RemoveKey : " + removeKey);

        }
        cache.put(key,value);
        queue.remove(Integer.valueOf(key));
        queue.add(Integer.valueOf(key));
    }
}

