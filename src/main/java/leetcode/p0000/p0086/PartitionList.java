package leetcode.p0000.p0086;


public class PartitionList {
    private ListNode small = null;

    public ListNode partition(ListNode head, int x) {
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val < x && node.next.val >= x) {
                small = node;
                node = node.next;
            } else if (node.next != null && node.val >= x && node.next.val < x) {
                ListNode tmp = node.next;
                node.next = node.next.next;
                if (small == null) {
                    tmp.next = head;
                    head = tmp;
                    small = head;
                } else {
                    tmp.next = small.next;
                    small.next = tmp;
                    small = small.next;
                }
            } else {
                node = node.next;
            }
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
