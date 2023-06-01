package leetcode.p2100.p2130;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        int max = 0;
        ListNode a = head, b = head;
        int len = 0;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            len++;
        }

        var arr = new int[len];
        b = head;
        int i = 0;
        while (a != null) {
            arr[i] += a.val;
            arr[len - i - 1] += b.val;
            max = Math.max(max, arr[i]);
            max = Math.max(max, arr[len - i - 1]);
            a = a.next;
            b = b.next;
            i++;
        }
        return max;
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
