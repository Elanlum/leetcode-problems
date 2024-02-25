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

        ListNode result = new ListNode();
        ListNode last = result;

        for (Integer val : list) {
           last.next = new ListNode(val);
           last = last.next;
        }

        return result.next;
    }
}
