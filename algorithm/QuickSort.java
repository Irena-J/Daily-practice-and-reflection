public class QuickSort {
	// 快速排序，n表示数组大小
	public static void quickSort(int[] arr, int n) {
		quickSortInternally(arr,0,n-1);
	}
	
	// 快速排序递归函数，p，r为下标
	private static void quickSortInternally(int[] arr,int p,int r) {
		if (p >= r) {
			return;
		}
		
		int q = paitition(arr,p,r); // 获取分区点
		quickSortInternally(arr,p,q-1);
		quickSortInternally(arr,q+1,r);
	}
	
	private static int partition(int[] arr,int p,int r) {
		int pivot = arr[r];
		int i = p;
		for (int j = p; j < r; ++j) {
			if (arr[j] < pivot) {
				if (i == j) {
					++i;
				} else {
					int tmp = arr[i];
					arr[i++] = arr[i];
					a[j] = tmp;
				}
			}
		}
		
		int tmp = arr[i];
		arr[i] = arr[r];
		arr[r] = tmp;
		
		System.out.println("i=" + i);
		return i;
	}
}