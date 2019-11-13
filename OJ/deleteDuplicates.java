public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode curNext = cur.next;
            if(cur.val == curNext.val){
                curNext = curNext.next;
                cur.next = curNext;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }