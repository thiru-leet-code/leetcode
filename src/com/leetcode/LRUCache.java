package com.leetcode;
import java.util.*;
/**
 * 
 * 146. LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 - capacity );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

 * 
 * @author thiru
 *
 */
class LRUCache {
    
    /*Map<Integer, Integer> cache = new HashMap<>();
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
    }*/

    Map<Integer, Integer> cache = null;
    int sizeLimit = 0;

    public LRUCache(int capacity) {
        this.sizeLimit = capacity;
        cache = new LinkedHashMap<>(capacity, (float) .5, true);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.size() == (sizeLimit) && !cache.containsKey(key)) {
            int removeKey = cache.keySet().iterator().next();
            cache.remove(removeKey);
            //System.out.println("RemoveKey : " + removeKey);

        }
        cache.put(key,value);
    }
}

