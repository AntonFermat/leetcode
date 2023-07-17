package leetcode.p0400.p0445;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var lr1 = reverse(l1);
        var lr2 = reverse(l2);

        ListNode sum = null, curr = null;
        int rest = 0;
        while (lr1 != null || lr2 != null) {
            var val = (lr1 == null ? 0 : lr1.val) + (lr2 == null ? 0 : lr2.val) + rest;
            rest = val / 10;
            val %= 10;
            if (sum == null) {
                sum = new ListNode(val);
                curr = sum;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }

            lr1 = lr1 == null ? null : lr1.next;
            lr2 = lr2 == null ? null : lr2.next;
            if (lr1 == null && lr2 == null && rest > 0) {
                curr.next = new ListNode(rest);
            }
        }
        return reverse(sum);
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node, prev = null;
        while (curr != null) {
            var tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
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
