package leetcode.p0000.p0092;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var fake = new ListNode();
        fake.next = head;
        ListNode prev = fake, cur = head, last = head;
        int count = 1;
        while (count <= right) {
            var curNext = cur.next;
            if (count < left) prev = cur;
            else if (count == left) last = cur;
            else {
                var prevNext = prev.next;
                prev.next = cur;
                cur.next = prevNext;
                last.next = curNext;
            }
            cur = curNext;
            count++;
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
