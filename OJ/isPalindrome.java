public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode p = slow.next;
        while(p != null){
            ListNode pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;    
        }
        while(slow != head){
            if(slow.val != head.val){
                return false;
            }
            if(head.next == slow){
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }