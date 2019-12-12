public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size=0;
        ListNode cur = root;
        while(cur!=null) {
        	size++;
        	cur=cur.next;
        }
        ListNode[] res = new ListNode[k];
        int[] length = new int[k];
        int avg=size/k, remain=size%k;
        for(int i=0;i<length.length;i++) {
        	length[i]=avg;
        	//将余数部分加到靠前的结点上
        	if(remain-->0)
        		length[i]++;
        }
        ListNode temp;
        cur=root;
        for(int i=0;i<length.length;i++) {
        	if(length[i]==0)
        		break;
        	int count=0;
        	ListNode subHead=cur;
        	while(++count<length[i]) {
        		cur=cur.next;
        	}
        	temp=cur.next;
        	cur.next=null;
        	res[i]=subHead;
        	cur=temp;
        }
        return res;
    }
}

