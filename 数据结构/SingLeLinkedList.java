class Anode{
    int data;
    Anode next;

    public Anode(int data){
        this.data = data;
        this.next = null;
    }
}
class SingLeLinkedList {
    Anode head;

    public SingLeLinkedList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        Anode node = new Anode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        Anode node = new Anode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Anode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //找index索引的前驱节点
    private Anode searchPrev(int index) {
        int count = 0;
        Anode cur = this.head;
        while (count < index - 1) {//要记得减一，因为先进去再出来判断的
            count++;
            cur = cur.next;
        }
        return cur;
    }

    //链表的长度
    public int getLength() {
        int count = 0;
        Anode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //能否在任意位置插入一个数据
    public boolean addIndex(int index, int data) {
        if (index < 0 || index > getLength()) {
            System.out.println("位置不合法");
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        Anode node = new Anode(data);
        Anode prev = searchPrev(index);
        node.next = prev.next;
        prev.next = node;//这个点你刚刚出问题了
        return true;
    }

    //查找是否包含关键字key在单链表中
    public boolean contains(int key) {
        Anode cur = this.head;
        while (cur != null) {//这个条件你刚刚也出问题了
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Anode searchkeyNode(int key) {
        Anode prev = this.head;
        //因为头已经判断过了，所以直接从头的next进行判断
        while (prev.next != null) {
            //if(prev.data==key){//注意你循环条件和这个要匹配的啊
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除第一次出现关键字key的节点
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        //找到关键字key的前驱
        Anode prev = searchkeyNode(key);
        if (prev == null) {
            System.out.println("没有你要删除的节点");
            return;
        }
        Anode dele = prev.next;
        prev.next = dele.next;
    }

    //删除所有值为key的节点
    public void removeKey(int key) {
        //定义两个变量，一个用来遍历，一个用来保存要删除的节点的前驱
        Anode prev = this.head;
        Anode cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        Anode node = this.head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    //打印一个单链表
    public void display() {
        Anode node = this.head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    //清空一个单链表
    public void clear() {
        Anode node = this.head;
        while (node != null) {
            node.data = 0;
            node = node.next;
        }
    }

    //反转一个单链表，两种办法，一种是头插,一种是通过定义三个变量
//    public Anode reverse1(){
//        Anode prev = this.head;
//        Anode cur = prev;
//            while(cur!=null){
//                prev.next = null;
//                cur= cur.next;
//                cur.next = prev;
//            }
//        return this.head;
//    }
    public Anode reverse2() {
        Anode prev = null;
        Anode cur = this.head;
        Anode newHead = null;
        while (cur != null) {
            Anode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;//为啥头节点是一个链表的标识
    }

    public void display2(Anode newHead) {
        Anode cur = newHead;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //如果中间节点有两个，返回第二个
    public Anode middleNode() {
        Anode fast = this.head;
        Anode slow = this.head;
        //这里的条件很关键啊，必须让fast走到最后一个节点之后循环终止，不然你小心空指针异常啊
        //因为如果你只判断了fast的next不为空，fast是走了两步的，万一第一步是fast第二部就刚好越界了
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Anode findKthToTail(int k) {
        if (k <= 0) {
            return null;
        }
        Anode fast = this.head;
        Anode slow = this.head;
        //k先走k-1步
        while (k - 1 > 0) {
            if (fast != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("没有这个节点");
            }
        }
        //fast已经走了k-1步之后，然后两个一起走
        //while(fast!=null){//注意区别找中间节点的判断条件，走到最后一个就为止了，所以这里如果这样写的话这里会空指针异常
        while (fast.next != null) {//否则当fast走到最后一个时候，还是进入了循环，这个时候fast又在走就出现空指针异常了
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //将两个有顺序的链表合并为一个新的有序链表并返回
    //给定以x为基准将链表分割成两部分，所有小于x的放在前面，大于x的放在后面
    public Anode partition(int x) {
        Anode cur = this.head;
        Anode beforeStart = null;
        Anode beforeEnd = null;
        Anode afterStart = null;
        Anode afterEnd = null;
        while (cur != null) {
            //每次把cur的下一个节点置空，因为，每遍历完一个，他的下一个都又可能是最后的一个节点
            Anode curNext = cur.next;
            cur.next = null;
            if (cur.data < x) {
                //第一次插入
                if (beforeStart == null) {
                    beforeStart = cur;//this.head
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                //第一次插入
                if (afterStart == null) {
                    afterStart = cur;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
                afterStart = beforeEnd.next;
            }
            //cur = cur.next;
            cur = curNext;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
//        if(afterStart!=null){
//            afterEnd.next = null;
        //}
        return beforeStart;
    }

    //删除链表中所有重复的节点，重复的节点不保留，返回链表的头指针
    public Anode deleNode() {
        Anode node = new Anode(-1);//提供一个虚拟节点，其实也可以就在原来的单链表中操作
        Anode cur = this.head;
        Anode temp = node;//这个新穿起来的节点
        while (cur != null) {//遍历单链表的结束条件
            if (cur.next != null && cur.data == cur.next.data) {
                //循环
                //推出循环，cur要多走一步
                //走完之后还要
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                    //temp.next = cur;//这样也可以

                }
            } else {
                //当前节点不等于下一个节点的时候
                node.next = cur;
                cur = cur.next;
                temp = temp.next;
            }
        }
        temp.next = null;//这样也可以
        return node.next;
    }

    //链表的回文结构(快慢指针的应用)
    public boolean chkPalindrome() {
        Anode fast = this.head;
        Anode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        Anode p = slow.next;//这里的p始终指向下一个要反转的节点。必须要两个变量，一个指向当前要反转的节点，
        //另外一个就要记录下一个反转的节点，因为反转这种东西是要涉及链表的指向断开的，所以以，涉及到反转或者下一个节点哟啊用到的必须在
        //定义一个新的节点进行标识，其实链表中的问题都可以归结为不同的引用变量来标记节点，完成节点的重组。
        while (p != null) {
            Anode pNext = p.next;//注意pNext不能定义到外面，因为你并不知道会不会发生空指针异常，所以必须先判断
            p.next = slow;
            slow = p;//slow就指向p所指向的位置了
            p = pNext;//这里之所以要分两次是因为你看你的循环条件，
        }
        while (slow != this.head) {
            if (slow.data != this.head.data) {
                return false;
            }
//            else {    这样写没法判断偶数回文,因为偶数情况下这两个是不可能相遇的，这个时候刚好擦肩而过。
//                slow = slow.next;
//                head = head.next;
//            }
            if (this.head.next == slow) {
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    //给定一个链表，判断是否有环//用python写一个爬虫验证一下
    // (快慢指针，一个走一步一个走两步是最早的时间相遇，那你走三步呢？没必要，且最坏情况下还可能不会相遇)
    public boolean hasCircle() {
        Anode fast = this.head;
        Anode slow = this.head;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
            //或者这部分可以这么写
//            if (fast == slow) {
//                break;
//            }
//        }
//        if(fast==null||fast.next==null){
//            return null;
//        }
        }
        return false;
    }

    //创建一个环
    public void createLoop() {
        Anode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }


    //给定一个链表，返回链表开始入环的第一个节点，如果无环，返回null
    //找出环的入口位置
    public Anode detectCycle() {
        Anode fast = this.head;
        Anode slow = this.head;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        return slow;
    }

}
    //将两个有序链表合为一个新的有序链表并返回，新链表的节点都是两个有序链表组成
    //找两个链表的公共节点
    //在测试类


