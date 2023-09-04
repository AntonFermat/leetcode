package leetcode.p0100.p0141;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode a = head, b = head;
        while (a != null && b != null && a.next != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) return true;
        }
        return false;
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
