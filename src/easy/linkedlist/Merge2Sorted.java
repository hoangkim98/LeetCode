package easy.linkedlist;

public class Merge2Sorted {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode res;
        if (list1.val <= list2.val) {
            res = list1;
            list1 = list1.next;
        } else {
            res = list2;
            list2 = list2.next;
        }
        ListNode cur = res;
        while (list1 != null || list2 != null) {
            if (null == list1 || (null != list2 && list1.val > list2.val)) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
