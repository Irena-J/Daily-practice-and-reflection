class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;

    }
}
class ListNode {
    Node head;

    public ListNode(){
        this.head = null;
    }
    //头插
    public void addFirst(int val){
       Node node = new Node(val);
       if(this.head==null){
           this.head = node;
       }else {  //你知道这里的一个else有多重要吗？如果你不写下去，就会死循环式的打印5.
           node.next = this.head;
           this.head = node;
       }
    }
    //尾插
    public void addLast(int val){
        Node node = new Node(val);
        Node cur = this.head;
        if(cur == null){
            this.head = node;
        }else{
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;//你这里要是写反了我跟你说就只打印一个了
        }
    }
    public void disply(Node newHead){
        Node node = newHead;
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    //反转单链表
    public Node reverse(){
        Node prev = null;
        Node cur = this.head;//记住你的cur永远是指向你要反转的那个节点
        Node newHead = null;
        while(cur!=null){//千万不要写成了cur.next
            Node curNext = cur.next;
            if(curNext==null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
            //curNext = curNext.next; 前面定义的时候已经有了哈
        }
        return newHead;
    }

}
