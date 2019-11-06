 public Node copy(Node head){
        if(head ==null){
            return null;
        }
        //1.老新节点串为一个链表
        Node cur = this.head;//
        while(cur!=null){
            Node node = new Node(cur.val,cur.next,null);//重新写构造
            Node temp = cur.next;//是当前要插入的节点
           //插入一个
            cur.next = node;
            cur = temp;
        }
        //2.开始处理random
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }else{
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        //3.拆分链表
        cur = head;
        Node newHead = cur.next;
        while(cur.next!=null){
            Node temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return newHead;
    }