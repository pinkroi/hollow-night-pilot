package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    public static class ListNode {
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

    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (null != head) {
            list.add(head);
            head = head.next;
        }
        for (int i = list.size() - 1; i > 0; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(0).next = null;
        return list.get(list.size() - 1);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (null != head) {
            list.add(head);
            head = head.next;
        }
        List<ListNode> pre = list.subList(0, m-1);
        List<ListNode> middle = list.subList(m-1, n);
        List<ListNode> suffix = list.subList(n, list.size());
        for (int i = middle.size() - 1; i > 0; i--) {
            middle.get(i).next = middle.get(i - 1);
        }
        if (!pre.isEmpty()) {
            pre.get(pre.size() - 1).next = middle.get(middle.size() - 1);
        }
        if (!suffix.isEmpty()) {
            middle.get(0).next = suffix.get(0);
        } else {
            middle.get(0).next = null;
        }
        return pre.isEmpty() ? middle.get(middle.size() - 1) : pre.get(0);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode reversedNode = reverseBetween(node1, 2, 4);
    }
}
