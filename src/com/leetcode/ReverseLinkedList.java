package com.leetcode;

/**
 * 
 * 
 * 
 * 
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * @author thiru
 *
 */

public class ReverseLinkedList {
	
	
	  public class ListNode {
	      int val;
	      ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	class Solution {
	    ListNode h = null;
	    ListNode first = null;
	    int v = 0;
	    public ListNode reverseList(ListNode head) {
	         
	        if (head != null && head.next!= null) {
	            if (first == null) {
	                 first = head;
	                 v = head.val;
	            }
	            reverseList(head.next).next = head;
	            head.next = null;
	           // System.out.println(head.val);
	            if(head == first) return h;
	            return head;
	        }else {
	            h = head;
	            //System.out.println(head.val);
	            return head;
	        }
	    }
	}

}
