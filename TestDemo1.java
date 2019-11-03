public class TestDemo1 {
    public static Anode getIntersectionNode(Anode headA,Anode headB){
        if(headA==null||headB==null){
            return null;
        }
        Anode pL = headA;//永远指向最长的单链表
        Anode pS = headB;//永远指向最短的单链表
        int lenA = 0;
        int lenB = 0;

        //分别求长度
        lenA = getLen(headA);
        lenB = getLen(headB);
        //求长度的差值
        int len = lenA-lenB;
        if(len<0){
            pL = headB;
            pS = headA;
            len = lenB-lenA;
        }
        //如果是负数，交换pl和pS
        //让pL走len步
        while(len>0){
            pL = pL.next;
            len--;
        }
        //走完len步两个同时走，直到它们的next值相同的时候，就是交点。
       while(pL!=pS&&pL!=null){//要考虑他本身，因为可能只有一个节点的情况
            pL = pL.next;
            pS = pS.next;
       }
       if(pL==pS&&pS!=null){
            return pL;
       }
       return null;
    }

    private static int getLen(Anode head){
        int count = 0;
        while(head.next!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    public static void createCut(Anode headA,Anode headB){
        headA.next.next = headB.next.next.next;
    }
    //常考
    public static Anode mergeTwoLista(Anode headA,Anode headB){
        Anode curA = headA;
        Anode curB = headB;
        Anode node = new Anode(-1);
        Anode temp = node;
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
        return node.next;
    }
    public static void main(String[] args) {
        SingLeLinkedList s1 = new SingLeLinkedList();
        s1.addLast(1);
        s1.addLast(2);
        s1.addLast(2);
        s1.addLast(1);
        s1.addLast(7);
        //s1.display();

        SingLeLinkedList s2 = new SingLeLinkedList();
        s2.addLast(11);
        s2.addLast(21);
        s2.addLast(53);
        s2.addLast(56);
        s2.addLast(57);
        s2.display();
        //createCut(s1.head,s2.head);
        //Anode node = getIntersectionNode(s1.head,s2.head);
        //System.out.println(node.data);
       Anode node = mergeTwoLista(s1.head,s2.head);
        s2.display2(node);

        //s1.removeKey(1);
        //s1.display();
        //Anode head = s1.reverse1();
        //Anode head = s1.reverse2();//返回值是一个新链表的头节点
        //s1.display2(head);
        //s1.middleNode();

        //Anode a=s1.findKthToTail(1);
        //System.out.println(a.data);

        //Anode node = s1.partition(4);
        //s1.display2(node);

        //boolean a = s1.chkPalindrome();
        //System.out.println(a);
        //s1.createLoop();

        //boolean a =  s1.hasCircle();
        //System.out.println(a);

        //s1.createLoop();
        //Anode a=s1.detectCycle();
        //System.out.println(a.data);

    }

}
