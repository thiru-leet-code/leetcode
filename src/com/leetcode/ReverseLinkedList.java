package com.leetcode;

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
