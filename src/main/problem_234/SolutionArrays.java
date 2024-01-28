package main.problem_234;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

//https://leetcode.com/problems/palindrome-linked-list/description/
public class SolutionArrays {

    public static boolean isPalindrome(ListNode head) {
        if (isNull(head) || isNull(head.next)) {
            return true;
        }

        int size = 1;
        ListNode node = head;
        while(nonNull(node.next)) {
            size++;
            node = node.next;
        }

        int[] array = new int[size];
        array[0] = head.val;

        for (int i = 1; i < size; i++) {
            head = head.next;
            array[i] = head.val;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
