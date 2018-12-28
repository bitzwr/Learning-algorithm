package org.wangbiao.leetcode;


/**
 * Leet Code Algorithm Problem 19:
 *
 * Description: Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/"><a/>
 */
public class $19RemoveNthNodeFromEndOfList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString() {
            return val + (next != null ? (" -> "  + next) : "");
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        int i = 0;
        ListNode node = head;
        ListNode targetPrefix = head;
        while (node != null) {
            node = node.next;
            if (i > n) { // 延迟
                targetPrefix = targetPrefix.next;
            }
            ++i;
        }
        if (i == n) { // 去头
            head = head.next;
        } else {
            targetPrefix.next = targetPrefix.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(head);
        ListNode node = removeNthFromEnd(head, 5);
        System.out.println(node);

    }
}
