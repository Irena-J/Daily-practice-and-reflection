public ListNode partition(ListNode head, int x) {
        ListNode bS = null;
        ListNode bE = null;
        ListNode aS = null;
        ListNode aE = null;
        ListNode temp = head;
        while(temp != null){
            ListNode tempNext = temp.next;
            temp.next = null;
            if(temp.val < x){
                if(bS == null){
                    bS = temp;
                    bE = bS;
                }else{
                    bE.next = temp;
                    bE = bE.next;
                }
            } else {
                if(aS == null){
                    aS = temp;
                    aE = aS;
                }else{
                    aE.next = temp;
                    aE = aE.next;
                }
            }
            temp = tempNext;
        }
        if(bS == null){
            return aS;
        }
        bE.next = aS;
        return bS;
    }