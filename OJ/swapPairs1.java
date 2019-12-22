两两交换链表中的节点，两种做法：
做法一：通过直接交换链表中的数据，这种做法的时间和空间复杂度都是最低的
public ListNode swapPairs(ListNode head) {
        
        ListNode pre = head;
       
        while(pre != null && pre.next != null){
            int temp = pre.val;
            pre.val = pre.next.val;
            pre.next.val = temp;
            pre = pre.next.next;  
        }
       return head; 
    }
	
方法二：机械的交换两个节点,可以参考链表的反转，这种消耗就比较大

