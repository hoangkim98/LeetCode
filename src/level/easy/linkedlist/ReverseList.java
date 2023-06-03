package level.easy.linkedlist;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        ListNode nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = newNode;
            newNode = head;
            head = nextNode;
        }
        return newNode;
    }


    public static void main(String[] args) {

    }
}
