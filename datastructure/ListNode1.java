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

    public ListNode() {
        this.head = null;
    }

    //头插
    public void addFirst(int val) {
        Node node = new Node(val);
        if (this.head == null) {
            this.head = node;
        } else {  //你知道这里的一个else有多重要吗？如果你不写下去，就会死循环式的打印5.
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插
    public void addLast(int val) {
        Node node = new Node(val);
        Node cur = this.head;
        if (cur == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;//你这里要是写反了我跟你说就只打印一个了
        }
    }

    public void display(Node newHead) {
        Node node = newHead;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void display1() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    //反转单链表(出场率超级高)，这里采用四个变量，也可以采用头插法
    public Node reverse1() {
        Node prev = null;
        Node cur = this.head;//记住你的cur永远是指向你要反转的那个节点
        Node newHead = null;
        while (cur != null) {//千万不要写成了cur.next
            Node curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
            //curNext = curNext.next; 前面定义的时候已经有了哈
        }
        return newHead;
    }

    public Node reverse2() {
        Node prev = null;
        Node cur = this.head;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }


    //用头插实现,我简直要醉了
    //将奇数的节点反转(阿里)
    //找倒数第n个节点，

//（坑）要注意
    public Node findKthToTail(int k) {
        Node slow = this.head;
        Node fast = this.head;
        if (k<0){
            System.out.println("没有这个节点");
            return null;
        }
            while (k - 1 > 0) {
            if(fast.next!=null) {    //每次走一部判断fast是否为空,如果你在这里写成fast！=null，那你可要注意了，下面的还有一个条件呢，因为你
                fast = fast.next;       //你这里当fast走到null的时候你下面的循环中还有啊，就
                k--;
            }else{
                System.out.println("你输入的不合法");
                return null;
            }
            }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //找单链表的中间节点如果中间节点有两个，那么返回后面的那个
    public Node middle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast.next!=null&&fast!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //以给定值x为基准，将链表分割为两部分，大于x的排在前面，小于的排在后面（坑）
    //这里需要定义四个变量，其中两个变量是大于x节点的头和尾，另外两个是小于x节点的头和尾
    //遍历当前链表，每一个数分别和x进行判断，判断后插入新的头中，这里又要分第一次插入的情况
    //当遍历结束，让大的头指向小的尾，最后返回小的头就可以了。（因为不能改变顺序所以要采用尾插）
    public Node partittion1(int x){
        Node bS = null;
        Node bE = null;
        Node aS = null;
        Node aE = null;
        Node cur = this.head;
        while(cur!=null) {
            Node curNext = cur.next;
            cur.next = null;//每遍历一个节点就把当前节点置空，因为每一个节点都可能是最后一个节点
            if (cur.val < x) {
                if (bS == null) {
                    bS = cur;
                    bE = bS;
                } else {
                    bE.next = cur;//头就不动了老哥，然后你再尾插就好了
                    bE = bE.next;
                }
            } else {
                if (aS == null) {
                    aS = cur;
                    aE = aS;
                } else {
                    aE.next = cur;
                    aE = aE.next;

                }
            }
            cur = curNext;
        }
        if(bS == null){ // 一定不要忽略这种情况，就是所有的都大于
            return aS;
        }
        bE.next = aS;
        return bS;
    }
    //在一个排序的链表中，存在重复节点，删除重复节点，可以申请虚拟的节点，你也可以选择在原来的单链表上操作（坑）
    public Node deleteDuplication(){
        Node node = new Node(-1);
        Node cur = this.head;
        Node temp = node;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
                temp.next = cur;//如果最后一个节点不重复就没问题，如果最后一个节点有重复，那问题就来了，你根本就不知道那个节点是null
            }else{
                temp.next = cur;
                cur = cur.next;
                temp = temp.next;
            }
        }
        return node.next;
    }

    //链表的回文结构
    //找到中间节点，然后将中间节点后面的反转，在判断每一个节点的值是否一样，最后相遇终止
    //一定要注意奇数偶数个节点的情况，如果只是偶数的话，它们的next相等那就走完了(坑)
    public boolean chkpalindrome(){
        Node slow = this.head;
        Node fast = this.head;
        while(fast.next!=null&&fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        Node p = slow.next;
        while(p!=null){
            Node q = p.next;

            p.next = slow;
            slow = p;
            p = p.next;
        }
        while(slow!=head){
            if(slow.val!=this.head.val){
                return false;
            }
            if(this.head.next == slow){
                return true;    //偶数情况
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return false;
    }
    //判断一个链表是否有环
    //思路：就是让两个引用同时走，一个走一步一个走两步如果能就会相遇
    public boolean hasCycle1(){
    Node fast = this.head;
    Node slow = this.head;
    while(fast!=null&&fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast==slow){ //其实这样写就回避了只有一个节点的情况或者没有节点的情况，不够好，修改见下面
            return true;
        }
    }
    return false;
    }
    public void loop(){
        Node cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    //这里在测试要先创建一个环
    public boolean hasCycle2(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return false;
        }
        return true;
    }
    //找到环的入口节点
    public Node detectCycle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return fast;
        }
        fast = this.head;
        while(fast!=slow){
            fast = fast.next;
            slow= slow.next;
        }
        return fast;
    }

}









