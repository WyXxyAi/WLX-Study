package Algorithm.Questions;

import java.util.List;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        int carry = 0;
        while (l1!=null||l2!=null||carry!=0){
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            if (a+b+carry>=10){//如果相加大于10
                temp.next = new ListNode(a+b+carry-10);
                carry=1;
                if (l1!=null)l1=l1.next;
                if (l2!=null)l2=l2.next;
                temp=temp.next;
            }else {
                temp.next = new ListNode(a+b+carry);
                carry=0;
                if (l1!=null)l1=l1.next;
                if (l2!=null)l2=l2.next;
                temp=temp.next;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode temp = l1;
        temp.next = new ListNode(9);temp = temp.next;
        temp.next = new ListNode(9);temp = temp.next;
        temp.next = new ListNode(9);temp = temp.next;
        temp.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode temp2 = l2;
        temp2.next = new ListNode(9);temp2 = temp2.next;
        temp2.next = new ListNode(9);
        ListNode res = addTwoNumbers(l1,l2);

        while (res.next!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
