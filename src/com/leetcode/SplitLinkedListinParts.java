package com.leetcode;
public class SplitLinkedListinParts {


    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ret = new ListNode[k];
        int i = 0;
        int l = length(head);
        int q = l/k;
        int cq = q;
        int m = l%k;
        while (head != null) {
            if (m>0) cq ++;
            m--;
            ListNode cls = null;
            ListNode h = null;
            for (; cq > 0 && head != null; cq--) {
                if (h == null) {
                    cls = new ListNode(head.val);
                    h = cls;
                }
                else {
                    cls.next = new ListNode(head.val);
                    cls = cls.next;
                }

                head = head.next;
            }
            ret[i] = h;
            i++;
            cq = q;
        }
        return  ret;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null ) {
            length++;
            head = head.next;
        }
        return  length;
    }
}
