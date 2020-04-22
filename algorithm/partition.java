import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode sNode = new ListNode(-1);
        ListNode lNode = new ListNode(-1);
        ListNode sCur = sNode;
        ListNode lCur = lNode;
        while (pHead != null) {
            if (pHead.next.val < x) {
                sCur.next = pHead;
                sCur = sCur.next;
            } else {
                lCur.next = pHead;
                lCur = lCur.next;
            }
            pHead = pHead.next;
        }
        
  
        lCur.next = null;
		sCur.next = null;
		sCur.next = lNode.next;
		
        return sNode.next;
    }
}
