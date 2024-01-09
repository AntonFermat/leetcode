package leetcode.p0100.p0109;

import leetcode.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head, prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        TreeNode tNode = new TreeNode(slow.val);
        if (prev != slow) {
            prev.next = null;
            tNode.left = sortedListToBST(head);
        }
        tNode.right = sortedListToBST(slow.next);

        return tNode;
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
