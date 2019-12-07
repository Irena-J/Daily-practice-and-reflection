 class ListNode11_6 {
    int data;
    ListNode11_6 prev;
    ListNode11_6 next;

    public ListNode11_6(int data){
        this.data = data;
        //ListNode11_6 prev = null;
        //ListNode11_6 next = null;
    }
}
class DoubleList {
    ListNode11_6 head;
    ListNode11_6 last;

    public DoubleList() {
        this.head = null;
        this.last = null;
    }

    //头插
    public void addFirst(int data) {
        ListNode11_6 node = new ListNode11_6(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            head.prev = node;
            this.head = node;
            //注意此时不必再把prev赋值， 因为你看你的构造并没有给prev初始化，此时就默认他是null，当然你也可以把他初始化
        }
    }

    //尾插
    public void addLast6(int data) {
        ListNode11_6 node = new ListNode11_6(data);
        if(head==null){
         this.head = node;
         this.last = node;
        }else{
            last.next = node;
            node.prev = last;
            last = node;
        }
    }
    public void disply6(){
        ListNode11_6 cur = this.head;
        while(cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    private ListNode11_6 searchIndex(int index){
         ListNode11_6 cur = this.head;
        int count = 0;
        while(count < index){
            count++;
            cur = cur.next;
        }
        return cur;
    }
    public void addIndex(int index,int val){
        ListNode11_6 node = new ListNode11_6(val);
        if(index<0){
            System.out.println("不合法");
            return;
        }
        if(this.head == null){
            this.head = node;
            this.last = node;
        }
        ListNode11_6 cur = searchIndex(index);//一定要判断是否返回的是空
        if(cur == null){
            return;
        }
//        pre.next = node;
//        node.prev = pre;
//        node.next = pre.next;
//        pre.next.prev = node;
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        node.prev = node;
    }
    public boolean contains(int key){
        ListNode11_6 cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字key定位节点
    //返回删除的节点值
    //删头、尾、中间、是否有这个节点
    public int deleKey(int key){
        int oldData = -1;
        ListNode11_6 cur = this.head;
        while(cur != null){
            if(cur.data == key){
                oldData = cur.data;
                if(cur == this.head){
                    head = head.next;
                    head.prev.next = null;
                    return oldData;
                } else{
                cur.prev.next = cur.next;
                if(cur.next != null) {
                    cur.next.prev = cur.prev;
                }else{
                    //尾巴
                    this.last = cur.prev;
                }
                    return oldData;
                }
            }
            cur = cur.next;
        }
        return oldData;
    }
    //删除所有出现的关键字key
    public void removeAll(int key){
        ListNode11_6 cur = this.head;
        while(cur != null){
            if(head.data == key){

            }
        }
    }
    //清空双向链表
    public void clear6() {
        while (this.head != null) {
            ListNode11_6 cur = this.head.next;
            this.head.next = null;
            this.head.prev = null; //为下一次循环的时候可以清除，这只是其中的一种
            this.head = cur;
        }
        last = null;    //不要把尾节点忘记了。
    }
    public void clear3(){
        while (this.head != null){
            ListNode11_6 cur = this.head.next;
            while (cur != null){
                this.head.next = null;
                cur.prev = null;
                this.head = cur;
                cur = cur.next;
            }
            last = null;
        }
    }
}
