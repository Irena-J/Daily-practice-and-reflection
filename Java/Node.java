class   Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

 class ListChart{
    Node head;

    public ListChart(){
        this.head = null;
    }

     public void display(){
         Node cur = this.head;
         while(cur!=null){
             System.out.print(cur.data+"");
             cur = cur.next;
         }
         System.out.println();
     }
    //头插一个数据
    public void addFirst(int data){
        Node node = new Node(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = head;
            this.head = node;
        }
    }
    //尾插一个数据
     public void addLast(int data){
        Node node = new Node(data);
        if(this.head==null){
            this.head = node;
        }
        Node cur = this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next = node;
     }
    //得到单链表的长度
     public int getLength(){
        int count = 0;
        Node cur = this.head;
        while(cur.next!=null){
            count++;
        }
        return count++;
     }
     //找index-1的位置
     private Node getIndex(int index){
        Node cur = this.head;
        int count = 0;
        while(count< index-1){
            count++;
            cur = cur.next;
        }
        return cur;
     }

     //是否能在任意节点插入一个数据
     public boolean addIndex(int index,int data){
        if(index<0||index>this.getLength()){
            System.out.println("位置不合法");
            return false;
        }
        if(index==0){
            addFirst(data);
            return true;
        }
        //找到index-1的位置
         Node cur = getIndex(index);
         Node node = new Node(data);
         node.next = cur.next;
         return true;
     }
     //是否存在关键字key
     public boolean contain(int key){
        Node cur = this.head;
        while(cur.next!=null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
     }
     //找前驱
     private Node searchPrev(int key){
        Node prev = this.head;
        while(prev.next.data!= key){
            prev = prev.next;
        }
        return prev;
     }
     public void dele(int key){
        Node cur = this.head;
        if(this.head ==null){
            System.out.println("单链表为空");
            return;
        }
    //0 删除的节点是否是头节点
         if(this.head.data == key){
            this.head = this.head.next;
            return;
         }
         //找key的前驱
         Node prev = searchPrev(key);
         prev.next = cur.next;
     }

     public void deleAll(int key){
        Node cur = this.head.next;
        Node prev = this.head;
        if(head==null){
            return;
        }
        while(cur!=null){
            if(prev.next.data==key){
                prev.next = cur.next;
                cur = cur.next;
            } else if(prev.next.data!=key){
                prev = cur;
                cur = cur.next;
            } if(this.head.data==key){
                this.head = this.head.next;
            }
        }
    }
    public Node reverseList() {
        Node prev = null;
        Node newHead = null;
        Node cur = this.head;
        while(cur != null){
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    public void display1(){

    }
    //
     public Node middleNode(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast.next!=null&&fast!=null){
            slow = slow.next;
            fast = slow.next.next;
        }
        return slow;
     }
//     public Node FindKthToTail(int k){
//         Node fast = this.head;
//         Node slow = this.head;
//        if()
//            while(k-1>0){
//                fast = fast.next;
//                k--;
//            }
//            else{
//                System.out.println("null");
//                return null;
//            }
//        }

     }


