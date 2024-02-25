package main.problem_23;

import java.util.PriorityQueue;

public class GoodSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (ListNode listNode: lists) {
            while (listNode != null) {
                queue.add(listNode.val);
                listNode = listNode.next;
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode root = new ListNode(queue.poll());
        ListNode currentNode = root;

        while (!queue.isEmpty()) {
            currentNode.next = new ListNode(queue.poll());
            currentNode = currentNode.next;
        }

        return root;
    }
}
