package easy.linkedlist;

import java.util.List;

public class MiddleNode {

    public static ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (head != null) {
            length++;
            head = head.next;
        }
        int mid = length / 2 + 1;
        while (mid > 1) {
            mid--;
            temp = temp.next;
        }
        return temp;
    }


    public static void main(String[] args) {
        List<Integer> input = List.of(7, 10, 4, 6, 9, 1);
        ListNode head = ListNode.genInput(input);
        ListNode middleNode = middleNode(head);
        System.out.println(middleNode.val);
    }
}
