package com.leetcode;
/**
 * 
 * 23. Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


 * 
 * 
 * @author thiru
 *
 */
public class MergeKSortedList {

	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
	        if (lists == null || lists.length ==0) {
	            return null;
	        } 
	        if (lists.length == 1) {
	            return lists[0];
	        }
	        ListNode r = lists[0];
	        for (int i = 1; i <= lists.length-1; i++) {
	         r = merge(r, lists[i]);   
	        }
	        return r;
	        
	    }
	    
	    private ListNode merge(ListNode t, ListNode n) {
	        ListNode to = null;
	        ListNode to1 = null;
	        while (t != null || n!=null) {
	            if (t == null) {
	                if (to == null) {
	                    to1 = n;
	                } else
	                    to.next = n;
	                break;
	            } else if (n == null) {
	                if (to == null) {
	                    to1 = t;
	                } else
	                to.next = t;
	                break;
	            } else {
	                if (t.val <= n.val) {
	                    if (to == null){
	                        to = new ListNode(t.val);
	                        to1 = to;
	                    } else {
	                        to.next = new ListNode(t.val);
	                        to = to.next;
	                    }
	                    t = t.next;
	                }
	                else {
	                    if (to == null){
	                        to = new ListNode(n.val);
	                        to1 = to;
	                    } else {
	                        to.next = new ListNode(n.val);
	                        to = to.next;
	                    }
	                    n = n.next;
	                }
	            }
	            
	        }
	        return to1;
	    }
	}
}
