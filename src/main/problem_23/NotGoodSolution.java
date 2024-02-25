package main.problem_23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotGoodSolution {
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 1) {
            return lists[0];
        }

        List<Integer> total = new ArrayList<>();

        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }

            while (listNode != null) {
                total.add(listNode.val);
                listNode = listNode.next;
            }
        }

        Collections.sort(total);

        return reconstruct(total);
    }

    private static ListNode reconstruct(List<Integer> list) {

        if (list.size() == 1) {
            return new ListNode(list.get(0));
        }

        ListNode result = null;
        ListNode next = null;
        ListNode tmpTail = null;
        for (Integer val : list) {

            if (result == null) {
                tmpTail = new ListNode();
                result = new ListNode(val, tmpTail);
            } else {
                next = tmpTail;
                next.val = val;
                tmpTail = new ListNode();
                next.next = tmpTail;
            }

        }

        // null last element
        if (next != null) {
            next.next = null;
        }
        return result;
    }


    public static void main(String[] args) {

        ListNode zero = null;
        ListNode one = new ListNode(1, null);
        ListNode[] nodes = {zero, one};

        ListNode res = mergeKLists(nodes);

        System.out.println("OK");
    }
}
