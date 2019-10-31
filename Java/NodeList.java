class MyNode{
    int data;
    MyNode next;

    public MyNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class NodeList {
     MyNode head;

     public NodeList(){
         this.head = null;
     }

     //删除包含关键字key的节点
     public void remove(int key){
         //先判断是否有节点
         if(this.head==null){
             return;
         }
         //如果删除的是头节点(只需要将头节点后移一个)
         if(this.head.data==key){
             this.head = this.head.next;
         }
         //找到前驱，让前驱的next指向当前节点的next
         MyNode prev = SearchPrev(key);
         if(prev==null){
             return;
         }
         MyNode del = prev.next;
         prev.next = del.next;

     }
     private MyNode SearchPrev(int key){
         MyNode prev = this.head;
         while(prev.next!=null) {
             if (prev.next.data == key) {
                 return prev;
             }
            prev = prev.next;
         }
         return null;
     }
     public void removeAllKey(int key){
         MyNode prev = this.head;
         MyNode cur = this.head.next;

         while(cur!=null){
             if(prev.next.data==key){
                 prev.next = cur.next;
                 cur = cur.next;
             }else if(prev.next.data!=key){
                 prev = cur;
                 cur=cur.next;
             }
         }
         if(this.head.data==key){
             this.head = this.head.next;
         }
     }
     //反转链表,递归和循环(两种做法，一种是头插)
    //头插法反转链表
    public void reverse1(){
         MyNode prev = this.head;
         MyNode cur = prev.next;
         while(cur.next!=null){
             prev.next = null;
             cur.next = prev;
             cur = cur.next;
         }
    }
    //通过四个引用
    //cur永远指向当前要反转的节点
    //curNext即将要反转的下一个节点
    //prev，newHead
    public MyNode reverse2(){
        MyNode prev = null;
        MyNode newHead = null;
        MyNode cur = this.head;
        while(cur!=null){
            MyNode curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
                cur.next = prev;
                prev = cur;
                cur = curNext;
                //curNext = cur.next;
            }
            return newHead;
        }
        //找中间节点
    public MyNode middleNode(){
         MyNode slow = this.head;
         MyNode fast = this.head;
         while(fast!=null&&fast.next!=null){
             slow = slow.next;
             //slow = slow.next.next;这里不要糊涂啊
            fast = fast.next.next;
         }
         return slow;
    }
    //找倒数第K个节点
    public MyNode FindKthTotail(int k){
         if(k<0){
             return null;
         }
         MyNode fast = this.head;
         MyNode slow = this.head;
         while(k-1>0){
             if(fast.next!=null) {
                 fast = fast.next;
                 k--;
             }else{
                 System.out.println("没有此节点");
                 return null;
             }
         }
         while(fast.next!=null){
             fast = fast.next;
             slow = slow.next;
         }
         return slow;
    }
}

