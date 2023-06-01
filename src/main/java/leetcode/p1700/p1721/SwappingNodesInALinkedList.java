package leetcode.p1700.p1721;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fake = new ListNode();
        fake.next = head;
        var node = fake;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }

        var a = fake;
        for (int i = 0; i < Math.min(k - 1, len - k - 1); i++) {
            a = a.next;
        }

        var b = fake;
        for (int i = 0; i < Math.max(k - 1, len - k - 1); i++) {
            b = b.next;
        }

        var aNext = a.next;
        var bNext = b.next;

        if (b != aNext) {
            node = aNext.next;
            aNext.next = bNext.next;
            bNext.next = node;

            a.next = bNext;
            b.next = aNext;
        } else {
            a.next = bNext;
            aNext.next = bNext.next;
            bNext.next = aNext;

        }

        return fake.next;
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