package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Linked List
 */
public class LinkedList {

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

    // No.206 Reverse Linked List
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

    // No.92 Reverse Linked List II
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

    // No.83 Remove Duplicates from Sorted List
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode start = head;
        Set<Integer> set = new HashSet<>();
        ListNode prev = new ListNode();
        while (null != head) {
            if (!set.add(head.val)) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return start;
    }

    // No.82 Remove Duplicates from Sorted List II
    public static ListNode removeDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (null != head) {
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        List<ListNode> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (Integer.valueOf(1).equals(map.get(key))) {
                list.add(new ListNode(key));
            }
        }
        if (list.isEmpty()) {
            return null;
        }
        List<ListNode> ll = list.stream().sorted(Comparator.comparingInt(p -> p.val)).collect(Collectors.toList());
        for (int i = 0; i < ll.size() - 1; i++) {
            ll.get(i).next = ll.get(i + 1);
        }
        ll.get(ll.size() - 1).next = null;
        return ll.get(0);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(-1);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode node = removeDuplicates(node1);
    }
}
