import java.sql.SQLOutput;

public class Test2 {
    //找两个链表的第一个公共节点(题目都这么说了，那肯定就是两个链表有交叉了，你脑子里一天天在想啥啊)
    //思路：这里有两种情况，第一种就是一般情况，两个链表的长度不一样，那么这个做法就是分别求出两个链表
    //的长度，然后的到差值，注意如果为负数的情况，所以这里就定义两个变量，一个永远指向最长的那个，这样如果结果是负数，交换就好了
    //当得到相差定的长度之后就让长的先走差值，然后长的短的一起走，这样当他们相等的时候就是公共节点了。
    //特殊情况两个链表一样长或者亮
    public static Node getNode(Node headA,Node headB){
        if(headA==null||headB==null){
            return null;
        }
        Node pL = headA;//这里有this就会报错的
        Node pS = headB;//让pS指向最短的
        int lenA = getlen(headA);
        int lenB = getlen(headB);
        int len = lenA-lenB;
        while(len<0){
            pL = headB;
            pS = headA;
            len = -len;
        }
        while(len>0){
            pL = pL.next;
            len--;
        }
        while(pL!=pS&&pL!=null){
            pL = pL.next;
            pS = pS.next;
        }
        if(pL == pS&&pS!=null){
            return pL;
        }
        return null;
    }
    private static int getlen(Node head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }

    //合并两个单链表，这个哟啊注意这两个链表本来就是有序的，所以，当其中一个访问完了，后面的直接挂在当前的链表后面就好，
    public static Node merge(Node headA,Node headB){
        Node node = new Node(-1);
        Node temp = node;
        while(headA!=null&&headB!=null){
            if(headA.val<headB.val){
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
            temp.next = headA;//如果headB已经遍历完了，这时候headB剩下的肯定是比当前节点大的，所以直接串起来就好
        }
        if(headB!=null){
            temp.next = headB;
        }
        return node.next; //返回新的链表中的头节点的下一个，因为这是你的虚拟节点，你的头节点-1，这个时候就可以释放掉。
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode();
        n1.addFirst(5);
        n1.addFirst(1);
        n1.addFirst(4);
        n1.addFirst(3);
        n1.addFirst(2);

       // n1.display1();

        n1.addLast(1);
        n1.addLast(7);
        n1.addLast(2);
        n1.addLast(2);
        n1.addLast(9);
        //Node node = n1.reverse();//你自己好好看看，你自己写的头插，然后你要反转，当然是 5 1 4 3 2啦，你是猪吗
        //n1.disply(node);
       // Node node = n1.reverse2();
        //n1.display(node);
        //n1.display1();
        //Node node =n1.middle();
        //System.out.println(node.val);
        //Node node =n1.findKthToTail(3);

//        Node node = n1.partittion1(4);
//        n1.display(node);

        //Node node = n1.deleteDuplication();
        //n1.display(node);
//        n1.loop();
//        boolean flg =n1.hasCycle2();
//        System.out.println(flg);

//        n1.loop();
//        Node flg = n1.detectCycle();
//        System.out.println(flg.val);
    }

}
