package company.google;/*
https://leetcode.com/problems/add-two-numbers/description/
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */

import level.easy.linkedlist.ListNode;

import java.util.List;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head;
        int exceed = 0;
        int sum = l1.val + l2.val;
        if (sum >= 10) {
            head = new ListNode(sum - 10);
            exceed = 1;
        } else {
            head = new ListNode(sum);
        }
        ListNode temp = head;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            int l1Val = 0, l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }
            if (l2 != null) {
                l2Val = l2.val;
            }
            int tempSum = l1Val + l2Val + exceed;
            if (tempSum >= 10) {
                temp.next = new ListNode(tempSum - 10);
                exceed = 1;
            } else {
                temp.next = new ListNode(tempSum);
                exceed = 0;
            }
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Handle exceed 99 + 1 -> 100 -> new node
        if (exceed == 1) {
            temp.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {
//        List<Integer> input1 = List.of(2, 4, 3);
//        List<Integer> input2 = List.of(5, 6, 4);
//        ListNode.printLL(addTwoNumbers(ListNode.genInput(input1), ListNode.genInput(input2)));

//        List<Integer> input1 = List.of(9, 9, 1);
//        List<Integer> input2 = List.of(1);
//        ListNode.printLL(addTwoNumbers(ListNode.genInput(input1), ListNode.genInput(input2)));

        List<Integer> input1 = List.of(1, 9, 9, 9, 9, 9, 9, 9, 9, 9);
        List<Integer> input2 = List.of(9);
        ListNode.printLL(addTwoNumbers(ListNode.genInput(input1), ListNode.genInput(input2)));
    }
}