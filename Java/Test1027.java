class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySignalList{
    public ListNode head;
    public MySignalList(){
        this.head = null;
    }

    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head = node;
        }else {
            node.next = head;
            head = node;
        }
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head==null){
            this.head = node;
        }
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = node;
    }
    public void display(){

    }
    //查找是否包括关键字key
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur.next!=null){
            if(cur.data==key) {
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur.next!=null){
            count++;
        }
        return count;
    }
    public boolean addIndex(int index,int data){
        if(index<0||index>getLength())
            return false;
        if(index==0){
            addFirst(data);
        }
        //找到index-1的位置
        ListNode cur = searchIndex(index);

    }
    private ListNode searchIndex(int index){

    }

}




public class Test1027 {
    public static void main(String[] args) {
        MySignalList list1 = new MySignalList();

    }
}
