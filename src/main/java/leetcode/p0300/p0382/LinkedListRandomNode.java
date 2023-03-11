package leetcode.p0300.p0382;

import java.util.*;

/**
 * Brute force implementation
 */
public class LinkedListRandomNode {

    public LinkedListRandomNode(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    final private List<Integer> list = new ArrayList<>();
    final private Random random = new Random();

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
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