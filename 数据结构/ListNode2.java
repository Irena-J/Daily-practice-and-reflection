 class Node2 {
    int val;
    Node2 next;

    public Node2(int val){
        this.val = val;
        this.next = null;
    }
}

class ListNode2{
    Node2 head;
    public ListNode2(){
        this.head = null;
    }
    public void addFirst2(int val){
        Node2 node = new Node2(val);
        if(this.head ==null){
          this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    public void addLast2(int val){
        Node2 node = new Node2(val);
        Node2 cur = this.head;
        if(cur ==null){
            this.head = node;
        }else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    public void display(Node2 newHead){
        Node2 cur = newHead;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public void display2(){
        Node2 cur = this.head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    //反转单链表
    public Node2 reverse2(){
        Node2 prev = null;
        Node2 cur = this.head;//遍历链表，也就是当前要反转的链表
        Node2 newHead = null;
        while(cur!=null) {
            Node2 curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
            return newHead;
    }

    //倒数第k个
    public Node2 findK(int k){
        if(k<0){//k大于链表的长的的情况，因为链表是插入一个个节点后才能直到他的长的，这里写的话还要新写以个方法，
        System.out.println("不合法");
        return null;
        }
        Node2 fast = this.head;
        Node2 slow = this.head;
        while(k-1>0){
            if(fast.next!=null){ //可以通过每次走一下判空来避免写一个求长的的方法
                fast = fast.next;
                k--;
            }
        }
        while(fast.next!=null&&fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //一定值X为基础将链表分割为两部分，所有小于x的排在大于x的前面
    //要考虑所有节点都小于或者大于X的情况
    public Node2 div2(int x){
        Node2 cur = this.head;
        Node2 bs = null;
        Node2 be = null;
        Node2 as = null;
        Node2 ae = null;
        while(cur!=null){//每遍历完一个，他的下一个都可能是最后一个节点，所以每次都把他置空。
            Node2 curNext = cur.next;
            cur.next = null;
            if(cur.val<x){
                //第一次插入
                if(bs==null){
                    bs = cur;
                    be = cur;
                }else{  //虽然头不能再动，但是你是定义了一个be的
                    be.next = cur;
                    be = be.next;
                }
            }else{
                //第一次插入
                if(as == null){
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = curNext;
        }
        if(bs==null){
            return as;
        }
        be.next = as;
        return bs;
        }

        //在一个排序链表中删除重复的节点，重复的不保留，返回表头指针
    //定义一个新的，把所有不重复的串起来就好。
    public Node2 del2(){
        Node2 node = new Node2(-1);
        Node2 temp = node;//你总不能让头动呢
        Node2 cur = this.head;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                  cur = cur.next;
                }
                cur = cur.next;
            }else{
                temp.next = cur;
                cur = cur.next;
                temp = temp.next;
            }
            temp.next = null;//这样相当于把temp这个链表孤立开，有了才串上去，这样有重复的就不管了
        }

        return node.next;
    }
    //链表的回文结构
    //找到中间节点反转后，再比对，还有要注意偶数的情况
    public boolean hui(){
        Node2 fast = this.head;
        Node2 slow = this.head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node2 p = slow.next;    //要反转的当前节点，定义这样是不害怕空指针异常的
        while(p!=null){
            Node2 pNext = p.next;   //要反转的下一个节点
            p.next = slow;
            slow = p;
            p = pNext;
        }
        while(slow!=this.head){
            if(slow.val!=this.head.val){
                return false;
            }
            if(this.head.next == slow){
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    public boolean hasCicle2(){
        Node2 fast = this.head;
        Node2 slow = this.head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return false;
        }
        return true;
    }
    //找到环的入口节点
    //当快慢指针相遇之后，一个拉到头前，一个从当前开始走，当他们再次相遇就是入口节点
    public Node2 find(){
       Node2 fast = this.head;
       Node2 slow = this.head;
       while(fast!=null&&fast.next!=null){
           fast = fast.next.next;
           slow = slow.next;
           if(fast==slow){
               break;
           }
       }
       if(fast==null||fast.next==null){
           return null;
       }
       slow = this.head;
       while(fast!=slow){
           fast = fast.next;
           slow = slow.next;
       }
       return fast;
    }
}


