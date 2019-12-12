//一定不要忽略了，当只有一个节点的情况，一个节点的时候，还有就是本来这个节点就是有头节点的
//当你要删除头节点，返回的应该是head.next,返回null就和题意不符合。
public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        if(count < n ){
            return null;
        }
        if(count == n){
            return head.next;
        }
        ListNode fast = head;
        ListNode slow = head;
        if(n < 0){
            return null;
        }
        while(n-1 > 0){
            if(fast == null){
                return null;
            }
            fast = fast.next;
             n--;
        }
        ListNode prev = null;
        while(fast != null && fast.next != null){
             prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }