package leetcode.p0700.p0725;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        var node = head;
        while (node != null) {
            node = node.next;
            count++;
        }

        node = new ListNode();
        node.next = head;
        var res = new ListNode[k];
        int len = count / k + ((count % k == 0) ? 0 : 1);
        int x = (count % k == 0) ? len * k : len * (count % k);
        for (int i = 0, j = 0; i < count; i++) {
            if ((i <= x && i % len == 0) || (i > x && (i - x) % (len - 1) == 0)) {
                var tmp = node.next;
                node.next = null;
                res[j++] = tmp;
                node = tmp;
            } else node = node.next;
        }

        return res;
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
