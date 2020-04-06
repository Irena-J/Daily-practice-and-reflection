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