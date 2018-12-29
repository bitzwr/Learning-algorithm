package org.wangbiao.leetcode;

/**
 * Leet Code Algorithm Problem 21:Merge Two Sorted Lists
 *
 * Description: GMerge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/"><a/>
 */
public class $21MergeTwoSortedLists {

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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0), head = temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }

    public static ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        head1.next = node1;
        node1.next = node3;

        ListNode head2 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head2.next = node2;
        node2.next = node4;

        System.out.println(head1);
        System.out.println(head2);


        ListNode node = mergeTwoListsRecursion(head1, head2);
        System.out.println(node);
    }
}
