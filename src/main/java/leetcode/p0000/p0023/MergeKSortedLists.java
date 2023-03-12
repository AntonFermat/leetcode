package leetcode.p0000.p0023;


import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        Arrays.sort(lists, Comparator.comparing(l -> l == null ? Integer.MAX_VALUE : l.val));

        if (lists[0] == null) return null;
        ListNode head = lists[0];
        ListNode last = head;
        lists[0] = head.next;
        Arrays.sort(lists, Comparator.comparing(l -> l == null ? Integer.MAX_VALUE : l.val));

        while (lists[0] != null) {
            ListNode listNode = lists[0];
            last.next = listNode;
            last = listNode;
            ListNode next = listNode.next;
            lists[0] = next;
            Arrays.sort(lists, Comparator.comparing(l -> l == null ? Integer.MAX_VALUE : l.val));
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
