//两个链表的公共节点
public class FirstCommonNodeList {
    public static void main(String[] args) {
        Node node1 = null;
        Node node2 = null;
        Node node = findFirstCommonNode(node1, node2);
        System.out.println(node);
    }
    //单链表相交之后是
    private static Node findFirstCommonNode(Node node1, Node node2) {
        // 获取链表的长度
        int nLength1 = GetListLength(node1);
        int nLength2 = GetListLength(node2);
        // 应多走的步数
        int extraLength = nLength1 - nLength1;
        Node pNodeLong = node1;
        Node pNodeShort = node2;
        if (nLength1 < nLength2) {
            extraLength = nLength2 - nLength1;
            pNodeLong = node2;
            pNodeShort = node1;
        }
        // 长链表先走Length步
        while (extraLength > 0) {
            pNodeLong = pNodeLong.next;
            extraLength--;
        }
        Node pNodeCommon = null;
        // 两个链表同时向后走
        while (pNodeLong != null && pNodeShort != null) {
            pNodeLong = pNodeLong.next;
            pNodeShort = pNodeShort.next;
            if (pNodeLong == pNodeShort) {
                pNodeCommon = pNodeLong;
                break;
            }
        }
        return pNodeCommon;
    }
    // 获取链表长度
    private static int GetListLength(Node node1) {
        int length = 0;
        while (node1 != null) {
            length++;
            node1 = node1.next;
        }
        return length;
    }
    public static void creatCut(ListNode headA,ListNode headB){
        headA.next.next = headB.next.next.next;
    }
    //合并两个有序的单链表,出现频率极高
    public static ListNode mergeLists(ListNode headA,ListNode headB){
        ListNode curA = headA;//也可以不定义，走headA和headB
        ListNode curB = headB;
        ListNode node = new ListNode(-1);//定义虚拟节点
        ListNode temp = node;
        while(curA!=null&&curB!=null){
            if(curA.data<curB.data){
                temp.next = curA;
                curA = curA.next;
                temp = temp.next;
            }else{
                temp.next = curB;
                curB = curB.next;
                temp = temp.next;
            }
        }
        if(curA!=null){
            temp.next = curA;
        }
        if(curB!=null){
            temp.next = curB;
        }
        return node;
    }
    public static ListNode mergetwoLists(ListNode headA,ListNode headB){
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){
                temp.next = headA;
                headA = headA.next;
                temp = temp.next;
            }else{
                temp.next = headB;
                headB = headB.next;
                temp = temp.next;
            }
        }
            if(headA!=null){
                temp.next = headA;
            }
            if(headB!=null){
                temp.next = headB;
            }
        return node.next;
        }
    }

