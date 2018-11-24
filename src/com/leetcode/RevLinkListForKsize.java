package com.leetcode;

import java.util.*;

public class RevLinkListForKsize {
	
	
	  public class ListNode {
	      int val;
	     ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 
	    public ListNode reverseKGroup(ListNode head, int k) { 
	    	int i = 1;
        Stack<ListNode> s = new Stack<>();
        ListNode f = null;
        ListNode y = null;
    ListNode t = null;
    
    String c = "";
    c.contains("ww");
    List<Integer> d = Arrays.asList(1,2);

    if (head == null) {
        return null;
    }
        if (head.next == null) {
            f = head;
        } else {
        while (head != null) {
            if (i == k) {
                if (f == null) {
                  f = new ListNode(head.val);
                    y=f;
                } else {
                    y.next = new ListNode(head.val);
                    y = y.next;
                }
                
                while (s.size() >0) {
                    y.next = new ListNode(s.pop().val);
                    y = y.next;
                }
                i=0;
            } else {
                if (i == 1) {
                    t = head;
                }
                s.push(new ListNode(head.val));
            }
            head = head.next;
            i++;
        }
            if (s.size() >0)
         while (t != null) {
             if (f == null) {
                 f = t;
                 y=f;
                 t = t.next;
             } else {
                  
                    y.next = t;
                    y = y.next;
                 t = t.next;
                 
             }
           
        }}
        return f;
    }
	
	
	public static void main(String[] a) {
		
		RevLinkListForKsize k = new RevLinkListForKsize();
		ListNode node = new RevLinkListForKsize().new ListNode(1);
		node.next = new RevLinkListForKsize().new ListNode(2);
		node.next.next = new RevLinkListForKsize().new ListNode(3);
		node.next.next.next = new RevLinkListForKsize().new ListNode(4);
		node.next.next.next.next = new RevLinkListForKsize().new ListNode(5);
		ListNode d = k.reverseKGroup(node, 2);
		while (d != null) {
			System.out.println(d.val);
			d = d.next;
		}
	}

}
