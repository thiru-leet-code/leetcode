package com.leetcode;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 <= k <= number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 * @author thiru
 *
 */

public class TopKFrequentElement {
	 public List<Integer> topKFrequent(int[] nums, int k) {
	        Map<Integer, Node> count = new HashMap<>();
	        PriorityQueue<Node> r = new PriorityQueue<>((a, b) -> {
	            return b.count-a.count;
	        });
	        for (int i =0; i <= nums.length-1; i++) {
	            Node d = count.getOrDefault(nums[i],new Node(nums[i], 0));
	            r.remove(d);
	            d.count++;
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
	    }
}
