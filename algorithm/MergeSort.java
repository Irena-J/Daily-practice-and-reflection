public class MergeSort {
	
	// 归并排序，n表示数组大小
	public static void mergeSort(int[] arr,int n) {
		mergeSortInternally(arr,0,n-1);
	}
	
	// 递归调用函数
	private static void mergeSortInternally(int[] arr,int p,int r) {
		// 递归终止条件
		if (p >= r) {
			return;
		}
		
		// 取 p 到 r 之间的中间位置 q，防止 (p+r) 的和超过 int 类型最大值
		int q = p + (r-p)/2;
		
		// 分治递归
		mergeSortInternally(arr,p,q);
		mergeSortInternally(arr,q+1,r);
		
		// 将arr[p...q] 和 arr[q+1...r] 合并为 arr[p...r]
		merge(arr,p,q,r);
	}
	
	private static void merge(int[] arr,int p,int q,int r) {
		int i = p;
		int j = q+1;
		int k = 0; // 初始化变量 i，j，k
		int[] tmp = new int[r-p+1]; // 申请一个大小跟 arr[p...r]一样的临时数组
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++]; // i++等于 i:=i+1
			} else {
				tmp[k++] = arr[j++];
			}
		}
		// 判断哪个子数组中有剩余的数据
		int start = i;
		int end = q;
		if (j <= r) {
			start = j;
			end = r;
		}
		
		// 将剩余的数据拷贝到临时数组tmp
		while (start <= end) {
		  tmp[k++] = a[start++];
		}

		// 将tmp中的数组拷贝回a[p...r]
		for (i = 0; i <= r-p; ++i) {
		  a[p+i] = tmp[i];
		}
	}
}