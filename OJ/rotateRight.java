public ListNode rotateRight(ListNode head, int k) {
		if(head==null || k<=0) {
			return head;
		}
		//创建一个特殊节点，快指针，慢指针，统计节点个数的cur
		ListNode p = new ListNode(-1);
		p.next = head;
		ListNode cur = p;
		ListNode low = p;
		ListNode fast = p;
		int n = 0;
		//统计链表个数
		while(cur.next!=null) {
			cur = cur.next;
			++n;
		}
		//边界条件不用忘记处理了
		//其实有这段最上面的head==null可以省略
		if(n==0 || k%n==0) {
			return head;
		}
		//还有一个边界条件不要忘了，k可能大于n，所以要取模
		n = k%n;
		//快指针先移动n步
		while(fast.next!=null && n>0) {
			fast = fast.next;
			--n;
		}
		//快指针，慢指针一起移动，找到需要切割的点
		while(fast.next!=null) {
			low = low.next;
			fast = fast.next;
		}
		//改变链表的指向关系，注意这里的步骤不要乱了
		//先让fast节点指向head(也就是p.next)
		//再是head(也就是p.next)指向low的下一个节点
		//这两步如果弄反了就会出现节点丢失了
		//最后不要忘记将low.next置空
		fast.next = p.next;
		p.next = low.next;
		low.next = null;
		return p.next;
	}

