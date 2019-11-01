class Node11_1 {
    int data;
    Node11_1 next;

    public Node11_1(int data){
        this.data = data;
        this.next = null;
    }
}
//无头单向非循环链表的实现
class NodeList11_1{
    Node11_1 head;//这个head你又一次的定义错了，他是节点不是链表

    public NodeList11_1(){
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        Node11_1 node = new Node11_1(data);
        if(this.head ==null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        Node11_1 node = new Node11_1(data);
        if(this.head ==null){
            this.head = node;
        }else{
            Node11_1 cur = this.head;
            while(cur.next==null ){
                cur.next = node;
            }
            cur = cur.next;
        }
    }
    //得到单链表的长度
    public int size(){
        int count=0;
        Node11_1 node = this.head;
        while(node.next!=null){
            count++;
        }
        return count;
    }
    //找index-1的位置
    public Node11_1 search(int index){
        Node11_1 cur = this.head;
        int count =0;
        while(count<index-1){
            count++;
            cur = cur.next;
        }
        return cur;
    }

    //能否再任意位置插入一个数据
    public boolean addIndex(int index,int data){
        if(index <0||index>this.size()){
            System.out.println("位置不合法");
        }
        if(index==0){
            addFirst(data);
            return true;
        }
        //一般情况，要找到index-1的位置才能插入
        Node11_1 prev = search(index);
        Node11_1 node = new Node11_1(data);
        node.next = prev.next;
        prev.next = node;
        return true;
    }
    //查找是否包含关键字key
    public boolean contains(int key){
        Node11_1 cur = this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字key的节点
    public void remove(int key){

    }
}

