public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;

        while (l1 != null || l2 !=null || carry != 0)
        {
            if(l1 != null)
            {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                carry += l2.val;
                l2 = l2.next;
            }
            dummy.next = new ListNode(carry%10);
            dummy = dummy.next;
            carry = carry/10;
        }
        return head.next;

    }
    public static void main(String[] args) {
        System.out.println(15/10);
        System.out.println(15%10);
    }

    }

