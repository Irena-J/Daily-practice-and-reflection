//节点类
class MyListNode{//一个节点类啊，他有data域也有next域，所以你抽象他的属性当然就是这两个了。而next域不是基本类型，这个要注意
    int data;
    MyListNode next;//这个地址为什么是类类型,我要找到一个节点就需要他的引用啊，

    public MyListNode(int data){
        this.data=data;
        this.next=null;
    }
}
//单链表
class SingalList {
    MyListNode head;//这个代表的是链表的第一个节点，通过第一个节点就能找到后面的，
                        //所以链表的第一个节点往往代表这个链表，空链表就是一个节点都没有，也就是head==null,第一个节点不存在
    public SingalList(){

    }
    //头插法
    public void addFirst(int data){
        MyListNode node = new MyListNode(data);//一个要插入的节点，此节点的数据域为data
        if(head==null){ //如果是第一次插入的情况。啥也没有的时候
           this.head=node;
        }else{
            node.next = head;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        MyListNode node = new MyListNode(data);
        if(head==null){
            this.head=node;
        }else{
            MyListNode cur = this.head;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //得到单链表的长度
    public int getLength(){
        MyListNode cur = this.head;
        int count = 0;
        while(cur!=null){
            count++;
        }
        return count;
    }
    //查找是否包含关键字key在单链表中
    public boolean contains(int key){
        MyListNode cur = this.head;//一i的那个要注意这句话啊，cur是节点类型的，把这头节点的引用给了cur，cur的地址就是头节点的
        while(cur.next!=null){           //这里千万不要糊涂了(cur!=null)
            if(cur.data==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    private MyListNode searchIndex(int index){
        MyListNode cur = this.head;
        int count = 0;
        while(count<index-1){
            count++;
            cur=cur.next;
        }
        return cur;//
    }
    public boolean addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return true;
        }
        if(index<0||index>getLength()){
            System.out.println("index不合法");
        }
        //找到index-1的位置
        MyListNode cur = searchIndex(index);
        MyListNode node = new MyListNode(data);
        node.next = cur;
        cur.next = node;
        return true;

        }

    }


    public void display(){
        MyListNode cur = this.head;//定义一个临时变量，从头开始走
        while (cur!=null){
            System.out.println(cur.data+"");
            cur = cur.next;
        }
        System.out.println();
    }

}
