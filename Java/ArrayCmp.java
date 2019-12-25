import java.util.ArrayList;
import java.util.LinkedList;
 
public class ArrayCmp {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start,end;
		final int MAX = 100000;
		int arr[]=new int[MAX];
		ArrayList<Integer> arraylist = new ArrayList<>();
		LinkedList<Integer> linklist = new LinkedList<>();
		/*初始化各个数组链表*/
		for (int i=0;i<MAX;i++)
		{
			arr[i]=i;
			arraylist.add(i);
			linklist.add(i);
		}
		/*随机访问测试*/
		System.out.println("随机访问测试("+MAX+"):");
		start = System.nanoTime();
		int tmp;
		for (int i=0;i<MAX;i++)
			tmp = arr[i];
		end = System.nanoTime();
		System.out.println("数组:    		"+(end-start));
		start = System.nanoTime();
		for (int i=0;i<MAX;i++)
			tmp=arraylist.get(i);
		end = System.nanoTime();
		System.out.println("arraylist:	"+(end-start));
		start = System.nanoTime();
		for (int i=0;i<MAX;i++)
			tmp=linklist.get(i);
		end = System.nanoTime();
		System.out.println("linkedlist:	"+(end-start));
		/*遍历测试*/
		System.out.println("遍历测试("+MAX+"):");
		start=System.nanoTime();
		for (int e:arr)
			tmp=e;
		end = System.nanoTime();
		System.out.println("数组:    		"+(end-start));
		start = System.nanoTime();
		for (int e:arraylist)
			tmp=e;
		end = System.nanoTime();
		System.out.println("arraylist:	"+(end-start));
		start = System.nanoTime();
		for (int e:linklist)
			tmp=e;
		end = System.nanoTime();
		System.out.println("linkedlist:	"+(end-start));
	}
 
}