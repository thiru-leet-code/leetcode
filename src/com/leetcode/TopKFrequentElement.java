package com.dictionary;

import java.util.*;

public class TopKFrequentElement {

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Node> count = new HashMap<>();
            PriorityQueue<Node> r = new PriorityQueue<>((a, b) -> {
                return b.count-a.count;
            });
            for (int i =0; i <= nums.length-1; i++) {
                Node d = count.get(nums[i]);
                if (d == null) {
                    d = new Node(nums[i], 0);
                }
                if (r.contains(d)) {
                    r.remove(d);
                }
                d.inc();
                count.put(nums[i],d);
                r.add(d);
            }
            List<Integer> u = new ArrayList<>();
            for (int y = 0 ; y<= k-1; y++) {
                u.add(r.poll().val);
            }
            return u;
        }

        class Node {
            int val;
            int count;

            Node(int v, int c) {
                this.val = v;
                this.count =c;
            }

            void inc() {
                this.count++;
            }
        }

}
