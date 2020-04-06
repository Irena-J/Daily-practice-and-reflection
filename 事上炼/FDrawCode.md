```

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num3 = sc.nextInt();
        int num2 = sc.nextInt();
        int num4 = sc.nextInt();
        
        int A = (num1 + num2) >> 1;
        int B = (num3 + num4) >> 1;
        int C = (num4 - num3) >> 1;
        
        if (((A-B) == num1) && ((A+B) == num2)) {
            if (((B-C) == num3) && ((B+C) == num4)) {
                System.out.println(A+" "+B+" "+C+" ");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }
    }
}
```

```
汽水瓶问题

import java.util.*;
public class Main{
	public static int drink(int n) {
		int total = 0; // 饮料总数
		// 当大于两个空瓶的时候才可以换饮料
		while (n > 2) {
			// n/3表示能够换来的饮料
			total = total + n/3;
			// 新的空瓶个数 n
			n = n/3 + n%3;
		}
		// 如果n==2，说明有两个空瓶可以同商家借一瓶
		if (n == 2) {
			total = total + 1;
		}
		return total;
	}
	public static void main(String[] args) {
		// 创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			n = sc.nextInt();
			System.out.println(drink(n));
		}
	}
}
```

```
数组中的逆序对
方式一：暴力解法
public class AntiOrder {
	public int count(int[] A, int n) {
	// write code here
	int count = 0;
	for (int i = 0; i < n; i++) {
		for (int j = i+1; j < n; j++) {
			if (A[i] > A[j]) {
				count++;
			}
		}
	}
		return count;
	}
}

方式二：分治思想

import java.util.*;
public class AntiOrder {
    public int count(int[] A, int n) {
    	if (A == null || n == 0) {
    		return 0;
    	}
        return mergeSortRecursion(A, 0, n - 1);
    } 
    public static int mergeSortRecursion(int[] arr, int l, int r) {
    	if (l == r) {
    		return 0;
    	} 
    	int mid = (l + r) / 2;
    //逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+左右结合成新的顺序数组时中出现的
    逆序对的数量；
    	return mergeSortRecursion(arr, l, mid) + 		     					   mergeSortRecursion(arr, mid + 1, r) +
               merge(arr, l, mid, r);
    }
    public static int merge(int[] arr, int left, 
    						int mid, int right){
    	int[] temp = new int[right - left + 1];
    	int index = 0;
    	int i = left;
    	int j = mid + 1;
    	int inverseNum = 0;// 新增，用来累加数组逆序对
    	while (i <= mid && j <= right) {
    		if (arr[i] <= arr[j]) {
   				 temp[index++] = arr[i++];
    		} else {
    			// 当前一个数组元素大于后一个数组元素时，累加逆序对
    			// s[i] > s[j] 推导出 s[i]...s[mid] > s[j]
    		inverseNum += (mid - i + 1);
			temp[index++] = arr[j++];
		}
	} 
	while (i <= mid) {
		temp[index++] = arr[i++];
	} 
	while (j <= right) {
		temp[index++] = arr[j++];
	} 
	for (int k = 0; k < temp.length; k++) {
		arr[left++] = temp[k];
	}
    return inverseNum;
	}
}
	
    			
```

