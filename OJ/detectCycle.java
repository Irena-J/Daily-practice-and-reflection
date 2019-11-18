
//时间复杂度最佳
public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        slow = head;
        while(fast != null && fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        if(fast == slow){
            return slow;
        }
        return null;
    }