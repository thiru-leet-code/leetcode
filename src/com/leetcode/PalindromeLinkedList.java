package com.leetcode;
/*
Given the head of a singly linked list, return true if it is a palindrome.



Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false


Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9


Follow up: Could you do it in O(n) time and O(1) space?

 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        StringBuilder r = new StringBuilder();
        StringBuilder f = new StringBuilder();
        if (head == null || head.next == null) return true;
        while (head.next != null) {
            r.insert(0, head.val);
            f.append(head.val);
            head = head.next;
        }
        r.insert(0, head.val);
        f.append(head.val);
        return r.toString().equals(f.toString());
    }
}
