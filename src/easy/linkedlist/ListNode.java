package easy.linkedlist;

import java.util.List;

public class ListNode {
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

    public static ListNode genInput(List<Integer> arr){
        ListNode head = new ListNode(arr.get(0));
        ListNode temp = head;
        for (int i = 1; i < arr.size(); i++) {
            ListNode curr = new ListNode(arr.get(i));
            temp.next = curr;
            temp = temp.next;
        }
        return head;
    }

    public static ListNode genCircleLL(List<Integer> arr, int pos){
        ListNode head = new ListNode(arr.get(0));
        ListNode tail = head;
        ListNode circle = null;
        for (int i = 1; i < arr.size(); i++) {
            ListNode curr = new ListNode(arr.get(i));
            tail.next = curr;
            tail = tail.next;
            if(pos == i){
                circle = tail;
            }
        }
        tail.next = circle;
        return head;
    }

}
