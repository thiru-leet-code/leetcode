package com.leetcode;

public class AddLinkedListReverse {
	
	
	  public class ListNode {
	     int val;
	      ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        return add(l1,l2,0);
	    }
	    
	    private ListNode add (ListNode l1, ListNode l2, int carry) {
	        if (l1 != null || l2 != null || carry > 0) {
	            int frst=0,sec=0,sum=0;
	            ListNode n1 = null;
	            ListNode n2 = null;
	            if (l1 != null) {
	                frst = l1.val;
	                n1 = l1.next;
	            } 
	            if (l2 != null) {
	                sec = l2.val;
	                n2 = l2.next;
	            }
	            sum= frst+sec+carry;
	            if (sum > 9) {
	                carry =1;
	                sum = sum -10;
	            }else {
	                carry =0;
	            }
	            ListNode d = new ListNode(sum);
	            ListNode next = add(n1, n2, carry);
	            d.next = next;
	            return d;
	            
	        }
	        return null;
	    }
	

}
