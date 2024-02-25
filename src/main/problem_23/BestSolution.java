package main.problem_23;

public class BestSolution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        int mid = (start + end) / 2;

        ListNode leftNode = mergeKLists(lists, start, mid);
        ListNode rightNode = mergeKLists(lists, mid + 1, end);

        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {

        if (listNode1 == null) {
            return listNode2;
        }

        if (listNode2 == null) {
            return listNode1;
        }

        ListNode result = new ListNode(0);
        ListNode currentNode = result;

        while (listNode1 != null && listNode2 != null) {
            int val1 = listNode1.val;
            int val2 = listNode2.val;

            if (val1 < val2) {
                currentNode.next = new ListNode(val1);
                listNode1 = listNode1.next;
            } else {
                currentNode.next = new ListNode(val2);
                listNode2 = listNode2.next;
            }

            currentNode = currentNode.next;
        }

        while (listNode1 != null) {
            currentNode.next = new ListNode(listNode1.val);
            currentNode = currentNode.next;
            listNode1 = listNode1.next;
        }

        while (listNode2 != null) {
            currentNode.next = new ListNode(listNode2.val);
            currentNode = currentNode.next;
            listNode2 = listNode2.next;
        }

        return result.next;
    }
}


