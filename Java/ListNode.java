public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}//节点类

class MySignalList{
    public ListNode head;

    public MySignalList(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
   //尾插法
   public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null){
            this.head = node;
        }else{
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = node;
        }
   }
   //查找是否含关键字key是否在单链表当中
    public boolean contains(int key){
     ListNode cur = this.head;
     while(cur!=null){
         if(cur.data==key){
             return true;
         }
         cur = cur.next;
     }
     return false;
    }
    //得到单链表的长度
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //找到index-1的位置
    private ListNode searchIndex(int index){
        ListNode cur = this.head;
        //cur->index-1
        int count = 0;
        while(count<index-1){
            count++;
            cur = cur.next;
        }
        return cur;
    }
    //任意位置插入，第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(index<0|index>getLength()){
            System.out.println("index不合法");
            return false;
        }
        if(index==0){
            addFirst(data);
            return true;
        }
        //找到index-1的位置
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        return true;
    }
    public void display(){
        ListNode cur = this.head;
        while(cur!=null){
            System.out.print(cur.data+"");
            cur = cur.next;
        }
        System.out.println();
    }
}
