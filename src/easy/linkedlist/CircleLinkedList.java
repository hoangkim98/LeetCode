package easy.linkedlist;

import java.util.List;

public class CircleLinkedList {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCircle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                isCircle = true;
                break;
            }
        }
        if (isCircle) {
            while (head != null) {
                if (head == slow) {
                    return head;
                }
                head = head.next;
                slow = slow.next;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        List<Integer> input = List.of(1,2);
        ListNode head = ListNode.genCircleLL(input, 0);
        System.out.println(detectCycle(head).val);
    }
}
