package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AllOne {

        class Element {
            Integer counts;
            String e;

            Element(int counts, String e) {
                this. counts = counts;
                this.e = e;
            }
            Element(Element e){
                this.counts = e.counts;
                this.e = e.e;
            }
        }

        Map<String, Element> counter = new HashMap<>();
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> {
            return a.counts.compareTo(b.counts);
        });

        PriorityQueue<Element> pqMax = new PriorityQueue<>((a, b) -> {
            return b.counts.compareTo(a.counts);
        });

    /** Initialize your data structure here. */
        public AllOne() {

        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            Element val = counter.get(key);
            if (val!=null) {
                pq.remove(val);
                pqMax.remove(val);
                counter.remove(key);
                Element d = new Element(val.counts+1, key);
                counter.put(key, d);
                pq.offer(d);
                pqMax.offer(d);
            } else {
                val = new Element(1, key);
                counter.put(key, val);
                pq.offer(val);
                pqMax.offer(val);
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            Element val = counter.get(key);
            if (val != null){
                pq.remove(val);
                pqMax.remove(val);
                if (val.counts == 1) {
                    counter.remove(key);
                } else {
                    counter.remove(key);
                    Element d = new Element(val.counts-1, key);
                    counter.put(key, d);
                    pq.offer(d);
                    pqMax.offer(d);
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (pqMax.peek() == null) {
                return "";
            }
            return pqMax.peek().e;
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
                if (pq.peek() == null) {
                    return "";
                }
                return pq.peek().e;

        }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

public static void main(String[] args) {
    AllOne one = new AllOne();
    one.inc("hello");
    one.inc("world");
    one.inc("leet");
    one.inc("code");
    one.inc("DS");
    one.inc("leet");
    System.out.println(one.getMaxKey());
    one.inc("DS");
    one.dec("leet");
    System.out.println(one.getMaxKey());
    one.dec("DS");
    one.inc("hello");
    System.out.println(one.getMaxKey());
    one.inc("hello");
    one.inc("hello");
    one.dec("world");
    one.dec("leet");
    one.dec("code");
    one.dec("DS");
    System.out.println(one.getMaxKey());
    one.inc("new");
    one.inc("new");
    one.inc("new");
    one.inc("new");
    one.inc("new");
    one.inc("new");

    System.out.println(one.getMaxKey());
    System.out.println(one.getMinKey());

}
}
