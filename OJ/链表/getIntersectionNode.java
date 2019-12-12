一、相交链表的三种解法
1、消除长度差
2、设置第三变量标记会相遇的节点
3、将链表的头和尾相连接，然后遍历，总会有一个点两个相遇。

//1、头尾连接遍历 总有一个点会相遇的哈，时间和空间的复杂度都较高
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        //定义了两个节点a和b，只要a和b不等就继续遍历
        while(a!=b) {
            //这步很关键，请对照动态图配合理解，当a的下一个为空时，
            //就a就从b链表头开始遍历
            a = (a!=null)? a.next : headB;
            //同理，b也是类似的
            b = (b!=null)? b.next : headA;
        }
		return a;
    }
//2、消除长度差

private int getLen(ListNode head){
	int count = 0;
	ListNode cur = head;
	while(cur != null){
		count++;
		cur = cur.next;
	}
	return count;
}
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	if(headA == null || headB == null){
		return null;
	}
	ListNode pL = headA;
	ListNode pS = headB;
	int lenA = getLen(headA);
	int lenB = getLen(headB);
	int len = lenA - lenB；
	if(len < 0){
		pL = headB;
		pS = headA;
		len = -len;
	}
	while(len > 0){
		pL = pL.next;
		len--;
	}
	while(pL != pS && pL != null){
		pL = pL.next;
		pS = pS.next;
	}
	if(pL == pS && pL！= null){
		return pL;
	}
	return null;
	
}
//3、设置第三变量