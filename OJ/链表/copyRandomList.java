public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            Node node = new Node(cur.val,cur.next,null);
            Node temp = cur.next;
            cur.next = node;
            cur = temp;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            } else {
                cur.next.random = null;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node newHead = cur.next;
        while(cur.next != null){
            Node temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return newHead;
    }