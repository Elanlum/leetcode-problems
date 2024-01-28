package main.problem_234;

import static java.util.Objects.isNull;

//https://leetcode.com/problems/palindrome-linked-list/description/
public class SolutionTwoPointers {

    public boolean isPalindrome(ListNode head) {
        if (isNull(head) || isNull(head.next)) {
            return true;
        }

        ListNode slow = head, fast = head, prev, temp;

        //two pointer to stop at the end and middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //null next of a middle element
        prev = slow;
        slow = slow.next;
        prev.next = null;

        //reverse order from middle to end
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // compare from two sides
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
