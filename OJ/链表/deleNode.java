 //未处理当最后的节点都是重复的情况
 public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
       while(cur != null){
           if(cur.next != null && cur.val == cur.next.val){//用cur.next就要防止空指针
                while(cur.next != null && cur.val == cur.next.val){//万一多个重复呢
                    cur = cur.next;
                }
           } else {
               temp.next = cur;
               temp = temp.next;
           }
           cur = cur.next;
       }
       return node.next;
    }
	
避免了最后的多个重复的情况，自己画图梳理的  哈哈哈哈,但是这样的话内存和时间都是最多的
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
       while(cur != null){
           if(cur.next != null && cur.val == cur.next.val){//用cur.next就要防止空指针
                while(cur.next != null && cur.val == cur.next.val){//万一多个重复呢
                    cur = cur.next;
                }
           } else {
               temp.next = cur;
               temp = temp.next;
           }
           cur = cur.next;
           temp.next = cur;//相当于删除了中间的重复节点，但是这个temp还是和cur后面额连着，如果置空则不同
       }
       return node.next;
    }
}	

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
       while(cur != null){
           if(cur.next != null && cur.val == cur.next.val){//用cur.next就要防止空指针
                while(cur.next != null && cur.val == cur.next.val){//万一多个重复呢
                    cur = cur.next;
                }
                cur = cur.next;
                temp.next = cur;//内存消耗少
           } else {
               temp.next = cur;
               temp = temp.next;
               cur = cur.next;
           }
       }
       return node.next;
    }
}

内存和时间和空间都是最少的，原因是你每次都把temp.nexd置为空，这样也就是两个链表并没有连起来哦
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode node = new ListNode(-1);
        ListNode temp = node;
       while(cur != null){
           if(cur.next != null && cur.val == cur.next.val){//用cur.next就要防止空指针
                while(cur.next != null && cur.val == cur.next.val){//万一多个重复呢
                    cur = cur.next;
                }
                cur = cur.next;
                temp.next = null;//我觉得还是把这一句防在这里比较好，
				//因为是因为有重复的才把最后节点的next域需要置空，不重复的最后一个肯定是null。
				//还有一个就是if如果不满足就会直接执行else，你if括号外和else之间的是不执行的。
				
           } else {
               temp.next = cur;
               temp = temp.next;
               cur = cur.next;
           }
       }
       return node.next;
    }
}