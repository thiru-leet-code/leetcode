package com.leetcode;
import java.util.*;
public class LFU {
	
	class LFUCache {
	    int size = 0;
	    Map<Integer, Value> cache = new HashMap<>();
	    TreeMap<Integer,LinkedList<Integer>> track = new TreeMap<>();

	    public LFUCache(int capacity) {
	        size = capacity;
	    }
	    
	    public int get(int key) {
	        if (cache.containsKey(key)) {
	            Value v= cache.get(key);
	            int precnt =v.cnt;
	            v.cnt++;
	            cache.put(key,v);
	            if(track.containsKey(precnt)) {
	                track.get(precnt).remove(Integer.valueOf(key));
	                if (track.get(precnt).size() == 0) track.remove(precnt); 
	            }
	            LinkedList ll = track.getOrDefault(precnt+1, new LinkedList<>());
	            ll.add(key);
	            track.put(precnt+1, ll );
	            return v.val;
	        }
	        return -1;
	    }
	    
	    public void put(int key, int value) {
	        if (!cache.containsKey(key) && cache.size() >= size && size > 0) {
	            Map.Entry<Integer, LinkedList<Integer>> tu = track.firstEntry();
	            LinkedList<Integer> g =  tu.getValue();
	            Integer least = g.poll();
	            cache.remove(least);
	            if (g.size() == 0) {
	                track.remove(tu.getKey());
	            }
	        }
	        if (size > 0 && cache.size() <= size) {
	             Value v= cache.getOrDefault(key, new Value(value, 0));
	            v.val = value;
	            v.cnt++;
	            cache.put(key, v);
	            if(track.containsKey(v.cnt-1)) {
	                track.get(v.cnt-1).remove(Integer.valueOf(key));
	                if (track.get(v.cnt-1).size() == 0) track.remove(v.cnt-1); 
	            }
	            LinkedList<Integer> tra = track.getOrDefault(v.cnt, new LinkedList<>());
	            if (tra.contains(key)) tra.remove(Integer.valueOf(key));
	            tra.add(key);
	            track.put(v.cnt, tra);
	        } 
	       
	        
	    }
	    
	    class Value {
	        int val;
	        int cnt;
	        
	        Value(int v, int c) {
	            val=v;
	            cnt=c;
	        }
	    }
	}

	/**
	 * Your LFUCache object will be instantiated and called as such:
	 * LFUCache obj = new LFUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */

}
